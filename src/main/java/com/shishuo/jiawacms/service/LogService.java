/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.shishuo.com/jiawacms/licenses
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.jiawacms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.jiawacms.dao.LogDao;
import com.shishuo.jiawacms.entity.Log;
import com.shishuo.jiawacms.entity.vo.PageVo;

/**
 * 日志服务
 * @author Herbert
 *
 */
@Service
public class LogService {
	
	@Autowired
	private LogDao logDao;
	
	/**
	 * 日志分页
	 * 
	 * @param logId
	 * @return pageVo
	 */
	public PageVo<Log> getLogPage(long logId,int pageNum) {
		PageVo<Log> pageVo = new PageVo<Log>(pageNum);
		pageVo.setUrl("");
		List<Log> list = this.getLogList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getLogListCount());
		return pageVo;
	}
	
	/**
	 * 增加日志
	 * @param description
	 * @return log
	 */
	public Log addLog(String description){
		Log log = new Log();
		log.setDescription(description);
		log.setCreateTime(new Date());
		logDao.addLog(log);
		return log;
	}
	
	/**
	 * 所有日志
	 * @param offset, rows
	 * @return list<Log>
	 */
	public List<Log> getLogList(long offset, long rows){
		return logDao.getLogList(offset, rows);
	}
	
	/**
	 * 所有日志
	 * @return Integer
	 */
	public int getLogListCount(){
		return logDao.getLogListCount();
	}
}
