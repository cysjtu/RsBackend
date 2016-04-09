package com.cy.backend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cy.backend.vo.Item;

@Service
public class ItemService {

	@Autowired
	private JdbcTemplate jdbc;
	
	private SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	
	public  void saveItem(Item item){
		
		String sql1="select count(*) from item where itemid=? ;";
		String sql2="insert into item(itemid,description,url,imageurl,creationdate,changedate) values(?,?,?,?,?,?) ;";
		
		String sql3="update item set description=?,url=?,imageurl=?,changedate=? where itemid=? ;";
		
		
		
		int cnt=jdbc.queryForInt(sql1);
		
		String date=sdf1.format(new Date());
		
		if(cnt==0){
			
			
			jdbc.update(sql2, item.getItemid(),item.getDescription(),item.getUrl(),item.getImageurl(),date,date);
			
		}
		else{
			jdbc.update(sql3, item.getDescription(),item.getUrl(),item.getImageurl(),date,item.getItemid());
			
		}
		
	}

	
	public Item getItem(Integer ItemId){
		String sql1="select * from item where itemid=? ;";
		
		List<Map<String,Object>> temp=jdbc.queryForList(sql1, ItemId);
		
		if(null!=temp && temp.size()>0){
			Map<String,Object> m=temp.get(0);
			
			Item item=new Item();
			item.setItemid(ItemId+"");
			item.setUrl((String) m.get("url"));
			item.setDescription((String) m.get("description"));
			item.setImageurl((String) m.get("imageurl"));
			
			return item;
		}
		
		return null;
		
	}
}
