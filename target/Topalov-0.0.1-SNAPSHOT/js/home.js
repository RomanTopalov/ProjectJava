$("window").load(function() {
  $("#body").removeClass("preload");
});

		$(".share-btn").mouseenter(function() {
			setTimeout(function() {
			$(".item-menu").addClass("visible")
			}, 500);
		});
		$(".share-btn").mouseleave(function() {
			setTimeout(function() {
			$(".item-menu").removeClass("visible")
			}, 500);
		});
		$(".item-menu").hover(function() {
			$(".item-menu").addClass("visible")
		});
		$(".item-menu").mouseleave(function() {
			setTimeout(function() {
			$(".item-menu").removeClass("visible")
			}, 500);
		});
		$(".container-item").hover(function() {
			setTimeout(function() {
			$(".container-item").css("z-index","1000")
			}, 500);
		});
