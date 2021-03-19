package com.ltts.Ram.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.ltts.Ram.Model.Booking;
//import com.ltts.Ram.Model.Member;
import com.ltts.Ram.Model.Menu;



@Repository
public class MenuDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertMenu(Menu f) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(f);
			//System.out.println(st);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}
		finally {
			sf.close();
		}
		
		return b;
	}
	
	
	/*
	 * public List<Member> getMembers(){ List }
	 */
	
	//public Member getMemberByEmail(String email) {
	//	Member m=new Member();
		
		
	//	return m;
	//}
	public List<Menu> getAllMenu(){
		Session session=sf.openSession();
        session.beginTransaction();
        
        List<Menu> li=sf.openSession().createCriteria(Menu.class).list();
        //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
        
        session.getTransaction().commit();
     
		return li;
		
	}
	
}