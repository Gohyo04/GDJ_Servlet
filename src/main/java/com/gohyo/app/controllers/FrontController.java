package com.gohyo.app.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gohyo.app.countries.CountryDAO;
import com.gohyo.app.regions.RegionDAO;
import com.gohyo.app.regions.RegionDTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String contextPath = request.getContextPath();
//		System.out.println("Context : "+contextPath);
//		
//		String method = request.getMethod();
//		System.out.println("Method : "+method);
//		
//		String info = request.getPathInfo();
//		System.out.println("info : "+info);
//		
//		String uri = request.getRequestURI();
//		System.out.println("uri : "+uri);
//		
//		String url = request.getRequestURL().toString();
//		System.out.println("url : "+url);
//		
//		String[] names = uri.split("/");
//		System.out.println(names.length);
//		for(String n : names) {
//			System.out.println(n);
//		}
		
		// 사용자가 입력한 uri
		String uri = request.getRequestURI();
		String[] names = uri.split("/");
		// 기본 경로 -> 어떤 조건도 만족하지않을때
		String v = "/WEB-INF/views/index.jsp";
		try {
			// names[1] views/(name[1] = 패키지명)
			if(names[1].equals("regions")) {
				// regionDAO 사용
				RegionDAO rdao = new RegionDAO();
				// names[2] views/패키지명/(name[2] = 메서드명)
				if(names[2].equals("list")) {
					List<RegionDTO> ar = rdao.getList();
					request.setAttribute("list", ar);	// 키, 값
					rdao.getList();
					v = "/WEB-INF/views/regions/list.jsp";
				}else if(names[2].equals("detail")) {
					String id = request.getParameter("region_id");
					RegionDTO rdto = new RegionDTO();
					rdto.setRegion_id(Integer.parseInt(id));
					rdto = rdao.getDetail(rdto);
					v = "/WEB-INF/views/regions/detail.jsp";
					request.setAttribute("dto", rdto);
				}
			}else if(names[1].equals("countries")){
				// countryDAO 사용
				CountryDAO cdao = new CountryDAO();
				if(names[2].equals("list")) {
					cdao.getList();
					v = "/WEB-INF/views/countries/list.jsp";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// jsp로 보내는 역할 ( JSP 의 절대경로!로 보내줘야한다 )
		RequestDispatcher view = request.getRequestDispatcher(v);
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
