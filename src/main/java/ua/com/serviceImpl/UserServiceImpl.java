package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dao.ProductDao;
import ua.com.dao.UserDao;
import ua.com.entity.Product;
import ua.com.entity.Role;
import ua.com.entity.User;
import ua.com.service.UserService;
import ua.com.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {

		validator.validate(user);

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);

	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	@Transactional
	public void buyProduct(Principal principal, String id) {
		
		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		Product product = productDao.findOne(Integer.parseInt(id));

		user.getProducts().add(product);

	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

	public User fetchUserWithProduct(int id) {
		return userDao.fetchUserWithProduct(id);
	}

	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);
	}

	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {

		request.getSession(false);
		Product product = productDao.findOne(id);

		Cookie cookieBook = new Cookie(product.getName(), String.valueOf(product.getId()));
		cookieBook.setMaxAge(24 * 60 * 60 * 60);
/*		cookieBook.setHttpOnly(true);*/
		cookieBook.setPath("/");
		request.getCookies();
		response.addCookie(cookieBook);
		return cookieBook;

	}

	public List<Product> userProductsCookie(HttpServletRequest request) {

		request.getSession(false);
		List<Product> products = new ArrayList<>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				
			} else {
				products.add(productDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		
		return products;

	}

	@Transactional
	@Override
	public void getOrder(Principal principal, String id, Cookie [] cookies,
			HttpServletResponse response) {

		User user = userDao.fetchUserWithProduct(Integer.parseInt(principal.getName()));
		Product product= productDao.findOne(Integer.parseInt(id));
		user.getProducts().add(product);

		sortCookie(cookies, id, response);

	}
	
	
		

	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
		
	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                /*cookie.setHttpOnly(true);*/
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}

	@Override
	public void updateProfile(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
		
	}


	
	
	
	
	
	
	
	
	
	
	
}
