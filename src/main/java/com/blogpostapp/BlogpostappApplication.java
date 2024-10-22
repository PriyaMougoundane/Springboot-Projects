package com.blogpostapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogpostappApplication implements CommandLineRunner {
	/*
   @Autowired
	BlogRepo blogRepo ;
   @Autowired
	CommentRepo commentRepo;



	public BlogpostappApplication(BlogRepo blogRepo, CommentRepo commentRepo) {
		this.blogRepo = blogRepo;
		this.commentRepo = commentRepo;
	}

	 */

	public static void main(String[] args) {
		SpringApplication.run(BlogpostappApplication.class, args);
	}


	public BlogpostappApplication() {
	}

	@Override
	public void run(String... args) throws Exception {

/*


		Blog blog1 = new Blog("Education is wealth","George Mullins", "Education is wealth for every country");
		blogRepo.save(blog1);
		Blog blog2 = new Blog("Corruption in India","Mark Tin", "Corruption is a big issue");
		blogRepo.save(blog2);
		Blog blog3 = new Blog("Spring framework","Tim Hortins", "New spring version is 6.0");
		blogRepo.save(blog3);
		Blog blog4 = new Blog("Springboot framework","Eric Johensen", "New springboot version is 6.0");
		blogRepo.save(blog4);


		Comments cm1 = new Comments(blog1, "Agreed point");
		commentRepo.save(cm1);
		Comments cm2 = new Comments(blog1, "Hope this applies for all countries");
		commentRepo.save(cm2);
		Comments cm3 = new Comments(blog3, "Good article");
		commentRepo.save(cm3);
		Comments cm4 = new Comments(blog3, "must needed skill");
		commentRepo.save(cm4);

*/




	}
}
