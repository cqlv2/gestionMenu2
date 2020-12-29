//package dev.controlleur;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import dev.entity.Menu;
//import dev.repository.MenuRepository;
//import dev.service.MenuService;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/menu")
//public class menuCtrl {
//
//	private MenuService menuServ;
//
//	public menuCtrl(MenuService menuServ) {
//		this.menuServ = menuServ;
//	}
//	
//	@GetMapping
//	public ResponseEntity<?> getAll(){
//		return ResponseEntity.ok().body(menuServ.getAll());
//	}
//	
//	@GetMapping(params = {"date1","date2"})
//	public ResponseEntity<?> getBetween(@RequestParam String date1, @RequestParam String date2){
//		return ResponseEntity.ok().body(menuServ.getBetween(date1, date2));
//	}
//	
//	@GetMapping(params = "day")
//	public ResponseEntity<?> getByDate(String day){
//		return ResponseEntity.ok().body(menuServ.getByDate(day));
//	}
//	
//	
//}
