package cn.edu.seu.eye.module.base.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.HashMap;

@Service
public class InitServiceImpl implements IInitService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(InitServiceImpl.class);
	

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	@Transactional
	public void init() {
		String sql= null;
		try {
			
			InputStream sqlFileIn = this.getClass().getResourceAsStream("/hip.sql");
			StringBuffer sqlSb = new StringBuffer();
			byte[] buff = new byte[1024];
			int byteRead = 0;
			while ((byteRead = sqlFileIn.read(buff)) != -1) {
				sqlSb.append(new String(buff, 0, byteRead, "utf-8"));
			}
			sqlFileIn.close();
			// Windows 下换行是 \r\n, Linux 下是 \n
			String[] sqlArr = sqlSb.toString().split("(;\\s*\\r\\n)|(;\\s*\\n)");
			for (int i = 0; i < sqlArr.length; i++) {
				sql = sqlArr[i].replaceAll("--.*", "").trim();
				if (!sql.equals("")) {
					namedParameterJdbcTemplate.update(sql, new HashMap<String, Object>());
				}
			}
		} catch (Exception ex) {
			logger.error("脚本执行出错",ex);
			throw new RuntimeException(ex);
		}
	}

}
