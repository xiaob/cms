/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.cms.entity.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageVo<T> {
	private int pageNum;
	private int count;
	private int offset;
	private int rows;
	private List<T> list;
	private String url;
	private String pageNumHtml;
	private int pageCount;
	private Map<String, String> args = new HashMap<String, String>();

	public PageVo(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		if (this.pageNum <= 0) {
			this.pageNum = 1;
			return 1;
		} else {
			return pageNum;
		}
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		this.pageCount = ((this.getCount() - 1) / this.getRows()) + 1;
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getOffset() {
		this.offset = (this.getPageNum() - 1) * this.getRows();
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPageNumHtml(String pageNumHtml) {
		this.pageNumHtml = pageNumHtml;
	}

	public String getPageNumHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<ul class=\"pagination\">");
		// 首页，上一页
		if (this.getPageNum() != 1) {
			sb.append("<li><a href='" + this.getUrl()
					+ "pageNum=1' title='首页'>&laquo; 首页</a></li>");
			sb.append("<li><a href='" + this.getUrl() + "pageNum="
					+ (this.getPageNum() - 1)
					+ "' title='上一页'>&laquo; 上一页</a></li>");
		}
		// 页码
		if (this.getPageCount() != 1) {
			int startNum = this.getPageNum() - 3 <= 1 ? 1
					: this.getPageNum() - 3;
			int endNum = this.getPageNum() + 3 >= this.getPageCount() ? this
					.getPageCount() : this.getPageNum() + 3;
			if (startNum > 1) {
				sb.append("<li><a href='javascript:void(0);'>...</a></li>");
			}
			for (int i = startNum; i <= endNum; i++) {
				if (i == pageNum) {
					sb.append("<li class='active'><a   href='" + this.getUrl()
							+ "pageNum=" + i
							+ "' class='number current' title='" + i + "'>" + i
							+ "</a></li>");
				} else {
					sb.append("<li><a href='" + this.getUrl() + "pageNum=" + i

					+ "' class='number' title='" + i + "'>" + i + "</a></li>");
				}
			}
			if (endNum < this.getPageCount()) {
				sb.append("<li><a href='javascript:void(0);'>...</a></li>");
			}
		}
		// 下一页，尾页
		if (this.getPageNum() < this.getPageCount()) {
			sb.append("<li><a href='" + this.getUrl() + "pageNum="
					+ (this.getPageNum() + 1)
					+ "' title='下一页'>下一页&raquo;</a></li>");
			sb.append("<li><a href='" + this.getUrl() + "pageNum="
					+ this.getPageCount() + "' title='末页'>末页 &raquo;</a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

}
