package com.fastcpus.biz.users.usersClient;

import com.fastcpus.biz.users.UsersDAO;
import com.fastcpus.biz.users.UsersVO;

import java.util.Scanner;

public class UsersUpdateClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsersVO vo = new UsersVO();
        System.out.print("수정할 id : ");
        vo.setId(sc.nextLine());
        System.out.print("pw 재입력 : ");
        vo.setPassword(sc.nextLine());

        UsersDAO dao = new UsersDAO();
        dao.updateUserById(vo);
    }
}
