package com.hlh.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hlh.config.FileUtil;
import com.hlh.config.Node;
import com.hlh.config.ReadFileTest;
import com.hlh.config.edge;
import com.hlh.pojo.Experts;
import com.hlh.pojo.TempO;
import com.hlh.pojo.Users;
import com.hlh.pojo.elink;
import com.hlh.pojo.enode;
import com.hlh.service.AppointmentsService;
import com.hlh.service.ExpertsService;
import com.hlh.service.OisService;
import com.hlh.service.UsersService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		System.out.print("a");
		return page;
	}
	
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		System.out.print("a");
		this.usersService.addUser(users);
		return "OK";
	}
	
	@RequestMapping("/heat")
	public String heat() {
		
		return "redirect:http://laptop-6hgvj006:9988/webapps/home/session.html?app=HeatToolbox";
	}
	
	@RequestMapping("/heat2")
	public String heat2() {
		
		return "redirect:http://laptop-6hgvj006:9988/webapps/home/session.html?app=heattransfertoolbox2";
	}
	
	@RequestMapping("/time")
	public String time() {
		
		return "redirect:http://laptop-6hgvj006:9988/webapps/home/session.html?app=timeseriestoolbox";
	}
	
	@RequestMapping("/login")
	public String login(Users users,HttpSession session) {
		boolean judge=false;
		List<Users> list=this.usersService.findUserAll();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(users.getName())&&list.get(i).getPassword().equals(users.getPassword())) {
				session.setAttribute("users", list.get(i));
				if (list.get(i).getType()==0) {
					return "userspage";
				}
				else if(list.get(i).getType()==1) {
					return "expertspage";
				}
				else {
					return "managerpage";
				}
				
			}
		}
		return "index";
	}
	
	
	@RequestMapping("/makeoi")
	public String makeOi() {
		
		return "oi";
	}
	
	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/changeinfo")
	public String changeInfo(Users users,HttpSession session) {
		Users u=(Users)session.getAttribute("users");
		users.setId(u.getId());
		
		usersService.updateUser(users);
		return "pc";
	}
	
	@RequestMapping("/findinfo")
	@ResponseBody
	public String findInfo(HttpSession session) {	
		Users u=(Users)session.getAttribute("users");
		int id = u.getId();
		Users users=usersService.findUserInfo(id);		
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("u", users);
		return jsonObject.toString();
		

	}
	@Autowired
	ExpertsService d;
	@RequestMapping("/findall")
	@ResponseBody
	public String findAll() {	
		List<Experts> list=this.d.findAll();		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u", list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map);
		return jsonObject.toString();
	}
	@Autowired
	OisService o;
	@RequestMapping("/bac")
	@ResponseBody
	public void bac(Integer id,Integer uid) {	
		usersService.updateUserBac(id);
		o.changeStatusBa(id);
	}
	
	@RequestMapping("/rel")
	@ResponseBody
	public void rel(Integer id,Integer uid) {	
		usersService.updateUserBac(id);
		o.changeStatusBa(id);
	}
	
	@RequestMapping("/datauploadeva")
	public String fileUploadeva(MultipartFile file,HttpServletRequest request,HttpSession session) throws Exception{

		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				break;
		default:
			break;
		} 
		}
		FileUtil.upload(file, request,uid);

	}
		return "redirect:http://laptop-6hgvj006:9988/webapps/home/session.html?app=evaluatetoolbox";
	}
	
	@RequestMapping("/datauploadeva2")
	public String fileUploadeva2(MultipartFile file,HttpServletRequest request,HttpSession session) throws Exception{

		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				break;
		default:
			break;
		} 
		}
		FileUtil.upload(file, request,uid);

	}
		return "redirect:http://laptop-6hgvj006:9988/webapps/home/session.html?app=evaluatetoolbox2";
	}
	
	@RequestMapping("/datauploadrel")
	public String fileUpload(Integer size,MultipartFile file,MultipartFile file2,HttpServletRequest request,HttpSession session) throws Exception{
		session.setAttribute("size", size);
		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				break;
		default:
			break;
		} 
		}
		FileUtil.upload2(file, request,uid);
		FileUtil.upload3(file2, request,uid);
	}
		return "maxrel2";
	}
	
	@RequestMapping("/getdatarel")
	@ResponseBody
	public String getdatarel(HttpServletRequest request,HttpSession session) throws Exception{
		int size=(int)session.getAttribute("size");
		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				break;
		default:
			break;
		} 
		}

	}
		HashMap<String, List> map=new HashMap<String, List>();//边
		HashMap<String, Node> nodemap=new HashMap<String, Node>();//节点

		ReadFileTest test = new ReadFileTest();
		   test.load("D:\\"+String.valueOf(uid)+"links.txt");
		   int count = 0;
		   int ccc=0;
		   for(int i=0;i<test.vec.size();i++){
			   
			   //System.out.println(test.vec.get(i).toString());
			   String [] arr = test.vec.get(i).toString().split("\\s+");
			   if (!map.containsKey(arr[0])) {
				   
				   List<edge> list=new ArrayList<>();
				   if (Double.parseDouble(arr[2])<0) {
					   list.add(new edge(arr[1], -Double.parseDouble(arr[3])));//负数
				}
				   else {
					   list.add(new edge(arr[1], Double.parseDouble(arr[3])));
				}
				   map.put(arr[0], list);
			   }
			   else {
				   if (Double.parseDouble(arr[2])<0) {
					   map.get(arr[0]).add(new edge(arr[1], -Double.parseDouble(arr[3])));//负数
				}
				   else {
					   map.get(arr[0]).add(new edge(arr[1], Double.parseDouble(arr[3])));
				}
			}
			   count++;
			   
		   }
		   //System.out.println("link number:"+count);
		   
		   ReadFileTest test2 = new ReadFileTest();
		   test2.load2("D:\\"+String.valueOf(uid)+"edges.txt");
		   count = 0;
		   for (int i = 0; i<test2.vec.size(); i++) {
			   String arr = test2.vec.get(i).toString();
			   if (!nodemap.containsKey(arr)) {
				   nodemap.put(arr, new Node(arr, false, 0,0));
			   }
			   count++;
		}
		   
		   StringBuffer stringBuffer=new StringBuffer();
		   List<Node> S=new ArrayList<>();//S
		   for (int k = 0; k < size; k++) {
			   long startTime=System.currentTimeMillis();
			   Iterator iter1 = nodemap.entrySet().iterator();
			   int maxcount=0;
			   String user="";
			   while (iter1.hasNext()) {
				   Iterator iter21 = nodemap.entrySet().iterator();//恢复节点状态
				   while (iter21.hasNext()) {
					   Map.Entry entry2 = (Map.Entry) iter21.next();	
					   ((Node) entry2.getValue()).setIsj(false);
					   ((Node) entry2.getValue()).setStatus(0);
				}
				   List<Node> iNodes=new ArrayList<>();//初始激活节点
				   for (int i = 0; i < S.size(); i++) {
					   S.get(i).setIsj(true); 
					   S.get(i).setStatus(1);
					   iNodes.add(S.get(i));
				}								   
				   int tempcount=0;//被激活节点计数;
				   boolean judge=true;//是否有新的节点激活
				   Map.Entry entry = (Map.Entry) iter1.next();	
				   if (!iNodes.contains((Node) entry.getValue())) {//不在inodes里
					   iNodes.add((Node) entry.getValue());
					   for (int ii = 0; ii < 1; ii++) {
						   Iterator iter3 = nodemap.entrySet().iterator();//恢复节点状态
						   while (iter3.hasNext()) {
							   Map.Entry entry3 = (Map.Entry) iter3.next();	
							   if (!iNodes.contains((Node) entry3.getValue())) {
								   ((Node) entry3.getValue()).setIsj(false);
								   ((Node) entry3.getValue()).setStatus(0);
							}
						}						
						   tempcount+=iNodes.size();
						   while (judge) {
							   judge=false;
							   List<Node> tList=new ArrayList<>();//记录新被激活节点			
							for (int i = 0; i < iNodes.size(); i++) {						
								List<Node> templist=map.get(iNodes.get(i).getUser());
								if (templist!=null) {
									for (int j = 0; j < templist.size(); j++) {
										if (!nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).isIsj()) {//判断当前激活节点连接的节点是否激活						
											if (((edge) map.get(iNodes.get(i).getUser()).get(j)).getP()<0) {
												if (Math.random()<-((edge) map.get(iNodes.get(i).getUser()).get(j)).getP()) {//负影响											
													nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).addCount();
													nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setIsj(true);
													if (iNodes.get(i).getStatus()==1) {
														nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setStatus(2);
													}
													else {
														nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setStatus(1);
														tempcount++;
													}
													tList.add(nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()));
													judge=true;
												}
											}
											else {//正影响
												if (Math.random()<((edge) map.get(iNodes.get(i).getUser()).get(j)).getP()) {											
													nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).addCount();
													nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setIsj(true);
													if (iNodes.get(i).getStatus()==1) {
														nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setStatus(1);
														tempcount++;													
													}
													else {
														nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()).setStatus(2);
													}
													tList.add(nodemap.get(((edge) map.get(iNodes.get(i).getUser()).get(j)).getUser()));
													judge=true;
												}
											}
											
										}
									}
								}						
							}
							iNodes=tList;
					}						  
					}		
					   
					   tempcount=tempcount/1;
					   //System.out.println("sum:"+tempcount);
					   if (tempcount>maxcount) {
						   System.out.println("sum:"+tempcount);
							maxcount=tempcount;
							user=((Node) entry.getValue()).getUser();
						}					  
					}				   					   
			}
			   
			   S.add(nodemap.get(user));
			   System.out.println(nodemap.get(user).getUser());
		   }
		   for (int i = 0; i < S.size(); i++) {
			   stringBuffer.append(S.get(i).user+",");
			   
		}
		   List<enode> enodes=new ArrayList<>();
		   Iterator iter = nodemap.entrySet().iterator();
		   while (iter.hasNext()) {
			   Map.Entry entry = (Map.Entry) iter.next();	
			   if (Math.random()<0.5) {
			   ((Node) entry.getValue()).setStatus(1);
			}
			   enodes.add(new enode(((Node) entry.getValue()).getUser(), ((Node) entry.getValue()).getUser(), 25, ((Node) entry.getValue()).getStatus()));

		}
		   List<elink> elinks=new ArrayList<>();
		   Iterator iter2 = map.entrySet().iterator();
		   while (iter2.hasNext()) {
			   Map.Entry entry = (Map.Entry) iter2.next();	
			   java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.0000"); 			   
			   for (int i = 0; i < ((List<edge>) entry.getValue()).size(); i++) {
				elinks.add(new elink((String)entry.getKey(), ((List<edge>) entry.getValue()).get(i).getUser(), String.valueOf(df.format(((List<edge>) entry.getValue()).get(i).getP())), String.valueOf(((List<edge>) entry.getValue()).get(i).getP())));
			}
			   
		}
		   
		   List<enode> maxenodes=new ArrayList<>();
		   for (int i = 0; i < S.size(); i++) {
			   maxenodes.add(new enode(S.get(i).getUser(), S.get(i).getUser(), 25, S.get(i).getStatus()));
		}
		   
		   List<elink> maxelinks=new ArrayList<>();
		   for (int i = 0; i < S.size(); i++) {
			   if(map.get(S.get(i).getUser())!=null) {
				   for (int j = 0; j < map.get(S.get(i).getUser()).size(); j++) {
					   java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.0000"); 	
					   boolean judge=true;
					   for (int k = 0; k < maxenodes.size(); k++) {
						if (((List<edge>) map.get(S.get(i).getUser())).get(j).getUser().equals(maxenodes.get(k).getName())) {
							judge=false;
						}
					}
					   if (judge) {
						   maxenodes.add(new enode(((List<edge>) map.get(S.get(i).getUser())).get(j).getUser(), ((List<edge>) map.get(S.get(i).getUser())).get(j).getUser(), 25, nodemap.get(((List<edge>) map.get(S.get(i).getUser())).get(j).getUser()).getStatus()));
					}
					   maxelinks.add(new elink(S.get(i).getUser(), ((List<edge>) map.get(S.get(i).getUser())).get(j).getUser(), String.valueOf(df.format(((List<edge>) map.get(S.get(i).getUser())).get(j).getP())), String.valueOf(df.format(((List<edge>) map.get(S.get(i).getUser())).get(j).getP()))));
				}
			   }
			  
		}
		   
		   
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("maxenodes", maxenodes);
		map2.put("maxelinks", maxelinks);
		map2.put("enodes", enodes);
		map2.put("elinks", elinks);
		map2.put("res", stringBuffer.toString().substring(0,stringBuffer.toString().length()-1));
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map2);
		return jsonObject.toString();
	}
	
	@RequestMapping("/getdatarel2")
	@ResponseBody
	public String getdatarel2(HttpServletRequest request,HttpSession session) throws Exception{
		int size=(int)session.getAttribute("size");
		Cookie[] cookies = request.getCookies();
		int uid=0;
		if (cookies != null && cookies.length > 0) {
		for (Cookie c : cookies) {
		 switch (c.getName()) {
		case "uid":
				uid=Integer.parseInt(c.getValue());
				break;
		default:
			break;
		} 
		}

	}
		HashMap<String, List> map=new HashMap<String, List>();//边
		HashMap<String, Node> nodemap=new HashMap<String, Node>();//节点

		ReadFileTest test = new ReadFileTest();
		   test.load("D:\\"+String.valueOf(uid)+"links.txt");
		   int count = 0;
		   int ccc=0;
		   for(int i=0;i<test.vec.size();i++){
			   
			   //System.out.println(test.vec.get(i).toString());
			   String [] arr = test.vec.get(i).toString().split("\\s+");
			   if (!map.containsKey(arr[0])) {
				   
				   List<edge> list=new ArrayList<>();
				   if (Double.parseDouble(arr[2])<0) {
					   list.add(new edge(arr[1], -Double.parseDouble(arr[3])));//负数
				}
				   else {
					   list.add(new edge(arr[1], Double.parseDouble(arr[3])));
				}
				   map.put(arr[0], list);
			   }
			   else {
				   if (Double.parseDouble(arr[2])<0) {
					   map.get(arr[0]).add(new edge(arr[1], -Double.parseDouble(arr[3])));//负数
				}
				   else {
					   map.get(arr[0]).add(new edge(arr[1], Double.parseDouble(arr[3])));
				}
			}
			   count++;
			   
		   }
		   //System.out.println("link number:"+count);
		   
		   ReadFileTest test2 = new ReadFileTest();
		   test2.load2("D:\\"+String.valueOf(uid)+"edges.txt");
		   count = 0;
		   for (int i = 0; i<test2.vec.size(); i++) {
			   String arr = test2.vec.get(i).toString();
			   if (!nodemap.containsKey(arr)) {
				   nodemap.put(arr, new Node(arr, false, 0,0));
			   }
			   count++;
		}
		   
		   
		   List<enode> enodes=new ArrayList<>();
		   Iterator iter = nodemap.entrySet().iterator();
		   while (iter.hasNext()) {
			   Map.Entry entry = (Map.Entry) iter.next();	
			   if (Math.random()<0.5) {
			   ((Node) entry.getValue()).setStatus(1);
			}
			   enodes.add(new enode(((Node) entry.getValue()).getUser(), ((Node) entry.getValue()).getUser(), 25, ((Node) entry.getValue()).getStatus()));

		}
		   List<elink> elinks=new ArrayList<>();
		   Iterator iter2 = map.entrySet().iterator();
		   while (iter2.hasNext()) {
			   Map.Entry entry = (Map.Entry) iter2.next();	
			   java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.0000"); 			   
			   for (int i = 0; i < ((List<edge>) entry.getValue()).size(); i++) {
				elinks.add(new elink((String)entry.getKey(), ((List<edge>) entry.getValue()).get(i).getUser(), String.valueOf(df.format(((List<edge>) entry.getValue()).get(i).getP())), String.valueOf(((List<edge>) entry.getValue()).get(i).getP())));
			}
			   
		}
		   
		   
		  
		   
		Map<String, Object> map2 = new HashMap<String, Object>();

		map2.put("enodes", enodes);
		map2.put("elinks", elinks);

		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulateAll(map2);
		return jsonObject.toString();
	}
}
