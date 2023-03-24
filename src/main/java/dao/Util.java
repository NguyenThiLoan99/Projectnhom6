package dao;

import model.phongban;

import java.util.List;
import java.util.Scanner;

public class Util {
    public int chooseDepartment(Scanner in){
        int idDeptScanner;
        phongbanDAO deptDAO = new phongbanDAO();
        List<phongban> deptList = deptDAO.getAll();

        for (int i = 0; i < deptList.size(); i++) {
            System.out.println(i+1 + " : " + deptList.get(i).getTenPB());
        }
        System.out.print("\t\tBạn chọn phòng ban: ");

        try {
            idDeptScanner = Integer.parseInt(in.nextLine());

        } catch (Exception e) {
            System.out.println("Nhập sai định dạng!!!");
            return -1;
        }
        return idDeptScanner;
    }
}
