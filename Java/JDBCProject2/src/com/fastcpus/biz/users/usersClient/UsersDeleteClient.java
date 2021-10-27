package com.fastcpus.biz.users.usersClient;

import com.fastcpus.biz.users.UsersDAO;
import com.fastcpus.biz.users.UsersVO;
import org.h2.engine.User;

import java.util.Scanner;

public class UsersDeleteClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UsersVO vo = new UsersVO();
        System.out.print("삭제할 ID : ");
        vo.setId(sc.nextLine());

        UsersDAO dao = new UsersDAO();
        dao.deleteUserById(vo);
    }
}
