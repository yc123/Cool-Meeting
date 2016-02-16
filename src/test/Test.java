package test;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.Dept;
import service.DeptService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DeptService service = (DeptService) ac.getBean("deptService");
		Dept dept = new Dept(3, "����");
		service.addDept(dept);
		System.out.println("��ӳɹ�");
		List<Dept> list = service.getAll();
		for(Dept ls:list)
		{
			System.out.println(ls.getDname());
		}
		System.out.println("id��ѯ"+service.getById(1).getDname());
		System.out.println("name��ѯ"+service.getByName("����").getDname());
		System.out.println("��ѯ�ɹ�");
		service.deleteDept(dept);
		System.out.println("ɾ���ɹ�");
	}

}
