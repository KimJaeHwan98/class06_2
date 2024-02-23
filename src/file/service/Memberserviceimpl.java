package file.service;

import java.util.Scanner;

import file.dao.MemberDAO;
import file.dto.MemberDTO;



public class Memberserviceimpl implements Memberservice{
	public MemberDAO dao;
	public Memberserviceimpl() {
		dao =new MemberDAO();
	}
	Scanner input =new Scanner(System.in);
	public void register() {
		
		System.out.println("1.회원가입");
		MemberDTO dto = new MemberDTO();
		System.out.println("아이디를 입력해주세요");
		dto.setId(input.next());
		System.out.println("이름을 입력해주세요");
		dto.setName(input.next());
		dao.register(dto);
	}
	public void search() {
		System.out.println("이름를 입력해주세요");
		String name =input.next();
		MemberDTO dto=dao.search(name);
		if(dto==null) {
			System.out.println("사용자가 없습니다.");
		}else {
			System.out.println(dto.getName());
			System.out.println(dto.getId());
		}
	}
	public void List() {
		System.out.println("회원 목록보기");
		String [] a=dao.List();
		for(int i=0;i<a.length;i++) {
		System.out.println(i+1+"."+a[i]);
		}
	}
	public void delete() {
		System.out.println("이름를 입력해주세요");
		String name =input.next();
		dao.delete(name);
		
		
	}
	
}
