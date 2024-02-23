package file.dao;
//exists file객체에 등록한 파일이 존재하는 지.
import java.io.BufferedInputStream; //파일에 있는 정보를 한번에 받아오겠다.
import java.io.BufferedOutputStream;// 버퍼라는 공간에 값을 저장해두고 저장이 끝나면 그 값을 한꺼번에 그 파일로 전송한다.
import java.io.File; // 파일 경로를 지정해준다. //파일의 기능을 사용하기위해서도 사용한다.
import java.io.FileInputStream; // 파일경로에서 자바로 가져오는 길을 열어준다.
import java.io.FileOutputStream; // 자바에서 파일경로로 가는 길을 열어준다.
import java.io.ObjectInputStream; // 파일에서 오프젝트로 가져온다.
import java.io.ObjectOutputStream; //오브젝트 값을 파일로 저장하기 위해서

import file.dto.MemberDTO;

public class MemberDAO {
	private String path ="D:\\핀테크\\members/";
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;
	private	FileInputStream fis;
	private	BufferedInputStream bis;
	private ObjectInputStream ois;

	public void register(MemberDTO dto){
		String p =path+dto.getName()+".txt";
		File file = new File(p);
		if(!(file.exists())) {
			try {
				fos = new FileOutputStream(p);
				bos = new BufferedOutputStream(fos);
				oos = new ObjectOutputStream(bos);
				oos.writeObject(dto);
				oos.close(); bos.close(); fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("이미 있는 아이디입니다.");
		}
	}
	public MemberDTO search(String name) {
		String p =path+name+".txt";
		File file = new File(p);
		MemberDTO dto=null;
		if(file.exists()) {
			try {
			fis= new FileInputStream(p);
			bis = new BufferedInputStream(fis);
			ois=new ObjectInputStream(bis);
			dto=(MemberDTO)ois.readObject();
			ois.close();bis.close();fis.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public String[] List() {
		File file = new File(path);
			return file.list();
	}
	public void delete(String name) {
		String p =path+name+".txt";
		File file = new File(p);
		if(file.exists()) {
			file.delete();
			System.out.println("사용자가 삭제되었습니다.");
		}else {
			System.out.println("사용자가 없습니다.");
		}
	}
}
