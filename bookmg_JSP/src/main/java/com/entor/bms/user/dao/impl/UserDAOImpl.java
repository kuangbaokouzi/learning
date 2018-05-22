package com.entor.bms.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.entor.bms.user.dao.UserDAO;
import com.entor.bms.user.entity.UserInfo;
import com.entor.bms.utils.DBUtil;

public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = LogManager.getLogger();

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<UserInfo> getAll() {
		List<UserInfo> infoList = new ArrayList<>();
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info";
			LOGGER.info("JDBC getAll() -> SQL = {}", sql);
			// 3.创建statement
			ps = conn.prepareStatement(sql);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				UserInfo info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
				infoList.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return infoList;
	}

	@Override
	public Integer getMaxId() {
		return 0;
	}

	@Override
	public UserInfo selectUserInfoByIdCard(String idCard) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where status != 0 and id_card = ?";
			LOGGER.info("JDBC selectUserInfoByIdCard() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, idCard);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public UserInfo selecUserInfoById(Integer uid) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where u_id = ?";
			LOGGER.info("JDBC selecUserInfoById() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public UserInfo selecUserInfoById(int uid, int ex_status) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where u_id = ? and status != ?";
			LOGGER.info("JDBC selecUserInfoById() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, ex_status);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public UserInfo selectByIdCardAndPassword(String idCard, String password) {
		UserInfo info = null;
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where status != 0 and id_card = ? and password = ?";
			LOGGER.info("JDBC selectByIdCardAndPassword() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, idCard);
			ps.setString(2, password);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return info;
	}

	@Override
	public void updatePassByIdCard(String idCard, String newpass) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set password=? where id_card=?";
			LOGGER.info("JDBC updatePassByIdCard() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2, idCard);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void updateStatusByUId(Integer uid, Integer status) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set status = ? where u_id = ?";
			LOGGER.info("JDBC updateStatusByUId() -> SQL = {}", sql);
			// 3.创建statement
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, uid);
			// 4.编译并执行SQL句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set name=?, password=?, status = ? where u_id = ?";
			LOGGER.info("JDBC updateUserInfo() -> SQL = {}", sql);
			// 3.创建statement
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getName());
			ps.setString(2, userInfo.getPassword());
			ps.setInt(3, userInfo.getStatus());
			ps.setInt(4, userInfo.getUid());
			// 4.编译并执行SQL句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void updatePicById(Integer uid, String pic) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set pic=? where u_id=?";
			LOGGER.info("JDBC updatePicById() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, pic);
			ps.setInt(2, uid);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void deleteUser(Integer uid) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "delete from user_info where u_id=?";
			LOGGER.info("JDBC deleteUser() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void insertUser(UserInfo userInfo) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "insert into user_info(name,id_card,password,status) values(?,?,?,?)";
			LOGGER.info("JDBC insertUser() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getName());
			ps.setString(2, userInfo.getIdCard());
			ps.setString(3, userInfo.getPassword());
			ps.setInt(4, userInfo.getStatus());
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public void batchDel(String[] uids) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "delete from user_info where u_id=?";
			LOGGER.info("JDBC updatePassByIdCard() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			for (String uid : uids) {
				ps.setInt(1, Integer.parseInt(uid));
				ps.addBatch();
			}
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	@Override
	public List<UserInfo> selectByName(String name) {
		List<UserInfo> infoList = new ArrayList<>();
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "select * from user_info where name like ?";
			LOGGER.info("JDBC getAll() -> SQL = {}", sql);
			// 3.创建statement
			ps = conn.prepareStatement(sql);
			ps.setString(1, '%' + name + '%');
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			rs = ps.executeQuery();
			// 5.迭代结果集，处理每一条记录
			while (rs.next()) {
				UserInfo info = new UserInfo();
				info.setUid(rs.getInt("u_id"));
				info.setName(rs.getString("name"));
				info.setPassword(rs.getString("password"));
				info.setIdCard(rs.getString("id_card"));
				info.setRentBooks(rentIdsToList(rs.getString("rent_ids")));
				info.setStatus(rs.getInt("status"));
				info.setPic(rs.getString("pic"));
				infoList.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, rs);
		}
		return infoList;
	}

	@Override
	public void updateRentBooksById(UserInfo userInfo) {
		try {
			// 1.获得数据库连接
			conn = DBUtil.getConnection();
			// 2.创建SQL句
			String sql = "update user_info set rent_ids=? where u_id=?";
			LOGGER.info("JDBC updateRentBooksById() -> SQL = {}", sql);
			// 3.创建statement对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, listToRentIds(userInfo.getRentBooks()));
			ps.setInt(2, userInfo.getUid());
			// 4.编译并执行SQL句，并将返回的数据保存到结果集对象中
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(conn, ps, null);
		}
	}

	/**
	 * 将id的集合转换成以逗号分割的租赁书籍的id的字符串
	 * 
	 * @param rentBooks
	 * @return
	 */
	private String listToRentIds(List<Integer> rentBooks) {
		StringBuffer buff = new StringBuffer();
		for (int index = 0; index < rentBooks.size(); index++) {
			if (index == 0) {
				buff.append(rentBooks.get(index));
			} else {
				buff.append(",").append(rentBooks.get(index));
			}
		}
		return buff.toString();
	}

	/**
	 * 将以逗号分割的租赁书籍的id的字符串转换成id的集合
	 * 
	 * @param rentIds
	 * @return
	 */
	private List<Integer> rentIdsToList(String rentIds) {
		List<Integer> list = new ArrayList<>();
		if (rentIds != null && !"".equals(rentIds)) {
			for (String id : rentIds.split(",")) {
				list.add(Integer.valueOf(id));
			}
		}
		return list;
	}
}
