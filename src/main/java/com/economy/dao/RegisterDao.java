package com.economy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.economy.bean.User;
import com.economy.utils.JDBCUtil;

public class RegisterDao {

	public static String registerUser(User user) {
		try {
			Connection con = JDBCUtil.getConnection();
			String query = "INSERT INTO `economyfinances`.`client` (`client_name`, `password`, `email`, `type`) VALUES (?,?,?,?);";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getMail());
			preparedStatement.setString(4, "client");
			int result = preparedStatement.executeUpdate();
			if (result != 0)
				return "Success";

		} catch (Exception e) {
			System.out.println(e);
		}

		return "Fail";
	}
}
