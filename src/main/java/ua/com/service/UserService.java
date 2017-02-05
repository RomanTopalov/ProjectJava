package ua.com.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import ua.com.entity.Product;
import ua.com.entity.User;

public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void buyProduct(Principal principal, String id);

    public void saveImage(Principal principal, MultipartFile multipartFile);

    User fetchUserWithProduct(int id);


//for email
    User findByUUID(String uuid);

  
    void update(User user);

    void updateProfile(User user);
    
    // for cookie
    
    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    
    List<Product> userProductsCookie(HttpServletRequest request);
    
    public void getOrder(Principal principal, String id, Cookie [] cookies, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
    
    
}
