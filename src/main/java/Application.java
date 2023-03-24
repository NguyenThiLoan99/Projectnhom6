import dao.Util;
import dao.taikhoanDAO;
import model.nhanvien;
import dao.nhanvienDAO;

import java.util.*;

import dao.phongbanDAO;
import model.phongban;

import java.util.List;
import java.util.Scanner;


public class Application {

    static nhanvien nv = new nhanvien();
    static phongban p = new phongban();

    private static void update(){

    }



    private static void checktaikhoan(Scanner in) {
        taikhoanDAO taikhoanDAO = new taikhoanDAO();
        String username = "", password = "";
        System.out.println("Đăng nhập");
        int count = 3;
        boolean isLogin = false;
        while (count != 0) {
            count = count - 1;
            System.out.print("Nhập username: ");
            username = in.nextLine();
            System.out.println("Nhập password: ");
            password = in.nextLine();

            if (taikhoanDAO.checktaikhoan(username, password)) {
                isLogin = true;
                break;
            }

            if (count == 0) {
            } else {
                System.out.printf("Bạn còn %d lần nhập \n", count);
            }
        }
        if (!isLogin) {
            System.out.println("Đăng nhập thất bại");
            System.exit(1);
        } else {
            System.out.println("Đăng nhập thành công");
        }
    }

    private static void menu() {
        System.out.println("--- QUẢN LÝ NHÂN SỰ ---");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý phòng ban");
        System.out.println("0. Quay lại");
    }

    private static void menu1() {
        System.out.println("--- QUẢN LÝ THÔNG TIN NHÂN VIÊN ---");
        System.out.println("1. Danh sách nhân viên");
        System.out.println("2. Thêm nhân viên ");
        System.out.println("3. Cập nhật thông tin nhân viên");
        System.out.println("4. Xóa nhân viên");
        System.out.println("5. Tìm kiếm nhân viên");
        System.out.println("6. Tính thuế nhân viên");
        System.out.println("0. Quay lại");
    }

    private static void menu2() {
        System.out.println("--- QUẢN LÝ PHÒNG BAN ---");
        System.out.println("1. Danh sách phòng ban");
        System.out.println("2. Thêm phòng ban");
        System.out.println("3. Sửa thông tin phòng ban");
        System.out.println("4. Xóa phòng ban");
        System.out.println("5. Tìm kiếm phòng ban");
        System.out.println("6. Thêm nhân viên vào phòng ban");
        System.out.println("0. Quay lại");
    }

/*    private static void xoaPB(Scanner in){
        dsPhongBan();
        System.out.print("\tNhập ID phòng ban cần xóa: ");
        int id=0;
        try {
            id = Integer.parseInt(in.nextLine());
        } catch (Exception ex) {
            System.out.println("Nhập sai định dạng!");
        }
        departmentDAO.delete(id);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        checktaikhoan(in);

        int option = -1;

        do {
            menu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // try-catch khi người dùng nhập lỗi
            if (option < 0 || option > 4) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    //Quản lý nhân viên
                    int option1 = -1;
                    do {
                        menu1();
                        System.out.print("Nhập lựa chọn: ");
                        option1 = Integer.parseInt(in.nextLine());
                        // try-catch khi người dùng nhập lỗi
                        if (option1 < 0 || option1 > 5) {
                            System.out.println("Vui lòng nhập lại!");
                            continue;
                        }
                        switch (option1) {
                            case 1:
                                // Ds NV
                                List<nhanvien> nhanvienList = nhanvienDAO.getAll();
                                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s" ,
                                        "Mã NV", "Họ tên", "Email", "Ngày vào làm", "Ngày sinh", "Sdt", "Chức vu", "Lương CV", "Mã phòng ban", "Người quản lý", "Bậc lương");
                                System.out.println();
                                for (int i = 0; i < nhanvienList.size(); i++) {
                                    nhanvien nv = nhanvienList.get(i);
                                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20d %-20s %-20s %-20d\n",
                                            nv.getMaNV(), nv.getHoTen(), nv.getEmail(), nv.getNgayvaolam(), nv.getNgaySinh(), nv.getSdt(), nv.getChucvu(), nv.getLuongCV(), nv.getMaPB(), nv.getNguoiQL(), nv.getBacLuong());
                                };
                                break;

                            case 2:
                                // Thêm NV

                                System.out.print("\tNhập mã NV: ");
                                nv.setMaNV(in.nextLine());
                                System.out.print("\tNhập họ tên NV: ");
                                nv.setHoTen(in.nextLine());
                                System.out.print("\tNhập email NV: ");
                                nv.setEmail(in.nextLine());
                                System.out.print("\tNhập ngày vào làm: ");
                                nv.setNgayvaolam(in.nextLine());
                                System.out.print("\tNhập ngày sinh: ");
                                nv.setNgaySinh(in.nextLine());
                                System.out.print("\tNhập số điện thoại: ");
                                nv.setSdt(in.nextLine());
                                System.out.print("\tNhập chức vụ: ");
                                nv.setChucvu(in.nextLine());
                                System.out.print("\tNhập lương chức vụ: ");
                                nv.setLuongCV(Integer.parseInt(in.nextLine()));
                                System.out.print("\tNhập mã phòng ban: ");
                                nv.setMaPB(in.nextLine());
                                System.out.print("\tNhập người quản lý: ");
                                nv.setNguoiQL(in.nextLine());
                                System.out.print("\tNhập bậc lương: ");
                                nv.setBacLuong(Integer.parseInt(in.nextLine()));

                                nhanvienDAO.insert(nv);
                                System.out.println("Thêm thành công!");
                            break;

                            case 3:
                                // Cập nhật thông tin NV

                                System.out.println("Nhập mã nv cần cập nhật:");
                                String ma = in.nextLine();
                                nhanvien tmp = nhanvienDAO.getById(ma);
                                if(tmp == null){
                                    System.out.println("Không có nhân viên này!");
                                    return;
                                }
                                //nhanvien nv = new nhanvien();
                                System.out.print("\tNhập họ tên NV: ");
                                nv.setHoTen(in.nextLine());
                                System.out.print("\tNhập email NV: ");
                                nv.setEmail(in.nextLine());
                                System.out.print("\tNhập ngày vào làm: ");
                                nv.setNgayvaolam(in.nextLine());
                                System.out.print("\tNhập ngày sinh: ");
                                nv.setNgaySinh(in.nextLine());
                                System.out.print("\tNhập số điện thoại: ");
                                nv.setSdt(in.nextLine());
                                System.out.print("\tNhập chức vụ: ");
                                nv.setChucvu(in.nextLine());
                                System.out.print("\tNhập lương chức vụ: ");
                                nv.setLuongCV(Integer.parseInt(in.nextLine()));
                                System.out.print("\tNhập mã phòng ban: ");
                                nv.setMaPB(in.nextLine());
                                System.out.print("\tNhập người quản lý: ");
                                nv.setNguoiQL(in.nextLine());
                                System.out.print("\tNhập bậc lương: ");
                                nv.setBacLuong(Integer.parseInt(in.nextLine()));
                                nhanvienDAO.update(nv,ma);
                                System.out.println("Cập nhật thành công");
                                break;

                            case 4:
                                // Xóa nhân viên
                                System.out.println("Nhập mã nv cần xóa:");
                                String maxoa = in.nextLine();
                                nhanvien tmp1 = nhanvienDAO.getById(maxoa);
                                if(tmp1 == null){
                                    System.out.println("Không có nhân viên này!");
                                    return;
                                }
                                nhanvienDAO.delete(maxoa);
                                System.out.println("Xóa thành công");
                                break;
                            case 5:
                                // Tìm kiếm nhân viên theo mã
                                System.out.println("nhập vào mã nhân viên cần tìm : ");
                                String id = in.nextLine();
                                nhanvien tmp2 = nhanvienDAO.getById(id);
                                if(tmp2 == null){
                                    System.out.println("phòng ban không tồn tại");
                                    return;
                                }
                                nhanvienDAO.getById(id);
                                System.out.println(tmp2);
                                break;
                            case 6:
                                // Tính thuế nhân viên
                                break;
                        }
                    } while (option1 != 0);
                    break;
                case 2:
                    //Quản lý phòng ban
                    int option2 = -1;
                    do {
                        menu2();
                        System.out.print("Nhập lựa chọn: ");
                        option2 = Integer.parseInt(in.nextLine());
                        // try-catch khi người dùng nhập lỗi
                        if (option2 < 0 || option2 > 6) {
                            System.out.println("Vui lòng nhập lại!");
                            continue;
                        }
                        switch (option2) {
                            case 1:
                                // Ds phòng ban
                                List<phongban> phongbanList = phongbanDAO.getAll();
                                System.out.printf("%-20s %-20s %-20s %-20s " ,
                                        "Mã PB", "Tên PB", "Địa chỉ PB", "Sđt PB");
                                System.out.println();
                                for (int i = 0; i < phongbanList.size(); i++) {
                                    phongban p = phongbanList.get(i);
                                    System.out.printf("%-20s %-20s %-20s %-20s\n",
                                            p.getMaPB(), p.getTenPB(), p.getDiachiPB(), p.getSdtPB());
                                };
                                break;

                            case 2:
                                // Thêm phòng ban
                                System.out.print("\tNhập mã PB: ");
                                p.setMaPB(in.nextLine());
                                System.out.print("\tNhập tên PB: ");
                                p.setTenPB(in.nextLine());
                                System.out.print("\tNhập địa chỉ PB: ");
                                p.setDiachiPB(in.nextLine());
                                System.out.print("\tNhập sđt PB: ");
                                p.setSdtPB(in.nextLine());
                                phongbanDAO.insert(p);
                                System.out.println("Thêm thành công!");
                                break;
                            case 3:
                                // Sửa thông tin phòng ban

                                System.out.println("Nhập mã phòng ban cần cập nhật:");
                                String maPB = in.nextLine();
                                phongban tmpPB = phongbanDAO.getById(maPB);
                                if(tmpPB == null){
                                    System.out.println("Không có phòng ban này!");
                                    return;
                                }
                                System.out.print("\tNhập mã PB: ");
                                p.setMaPB(in.nextLine());
                                System.out.print("\tNhập tên PB: ");
                                p.setTenPB(in.nextLine());
                                System.out.print("\tNhập địa chỉ PB: ");
                                p.setDiachiPB(in.nextLine());
                                System.out.print("\tNhập sđt PB: ");
                                p.setSdtPB(in.nextLine());

                                phongbanDAO.update(p,maPB);
                                System.out.println("Cập nhật thành công");
                                break;


                            case 4:
                                // Xóa phòng ban
                                List<nhanvien> StaffList =new ArrayList<>();
                                System.out.println("nhap ma phong ban can xoa");
                                String id=in.nextLine();
                                phongbanDAO.delete(id);
                                break;

                            case 5:
                                // Tìm kiếm phòng ban theo mã
                                System.out.println("nhập vào mã phòng ban cần tìm : ");
                                String id4 = in.nextLine();
                                phongban tmp4 = phongbanDAO.getById(id4);
                                if(tmp4 == null){
                                    System.out.println("phòng ban không tồn tại");
                                    return;
                                }
                                phongbanDAO.getById(id4);
                                System.out.println(tmp4);
                                break;

                            case 6:
                                // Thêm nhân viên vào phòng ban
                                System.out.print("\tNhập mã NV: ");
                                nv.setMaNV(in.nextLine());
                                System.out.print("\tNhập họ tên NV: ");
                                nv.setHoTen(in.nextLine());
                                System.out.print("\tNhập email NV: ");
                                nv.setEmail(in.nextLine());
                                System.out.print("\tNhập ngày vào làm: ");
                                nv.setNgayvaolam(in.nextLine());
                                System.out.print("\tNhập ngày sinh: ");
                                nv.setNgaySinh(in.nextLine());
                                System.out.print("\tNhập số điện thoại: ");
                                nv.setSdt(in.nextLine());
                                System.out.print("\tNhập chức vụ: ");
                                nv.setChucvu(in.nextLine());
                                System.out.print("\tNhập lương chức vụ: ");
                                nv.setLuongCV(Integer.parseInt(in.nextLine()));
                                System.out.println("\tChọn phòng ban: ");
                                phongbanList = phongbanDAO.getAll();
                                for (int i = 0; i < phongbanList.size(); i++) {
                                    System.out.printf("\t\t%-5d %-20s \n", i+1, phongbanList.get(i).getTenPB());
                                }
                                // Tam thoi nhap chinh xac
                                String phongban =  phongbanList.get(Integer.parseInt(in.nextLine()) - 1).getMaPB();
                                nv.setMaPB(phongban);
                                System.out.print("\tNhập người quản lý: ");
                                nv.setNguoiQL(in.nextLine());
                                System.out.print("\tNhập bậc lương: ");
                                nv.setBacLuong(Integer.parseInt(in.nextLine()));


                                //nv.setMaPB(MaPB);

                                nhanvienDAO.insert(nv);
                                break;


                        }
                    } while (option2 != 0);
                    break;

            }
        }
        while (option != 0);
                    in.close();
            }
    }