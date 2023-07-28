package cash.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cash.service.CounterService;

@WebListener
public class CountListener implements HttpSessionListener { // 세션이 생성될때 실행된다.
	private CounterService counterService;
	
	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println(se.getSession().getId() + "의 새로운 세션이 생성되었습니다.");
        
    	// 세션이 생길때마다 현재 접속자 수 + 1 -> application.attribute 
    	ServletContext application = se.getSession().getServletContext();
    	int currentCounter = (Integer)(application.getAttribute("currentCounter"));
    	application.setAttribute("currentCounter", currentCounter+1);
    	
    	// 오늘 접속자 수 + 1 -> DB에도 +1
    	this.counterService = new CounterService();
    	int counter = counterService.getCounter(); // 오늘 카운트 수
    	
    	// 오늘날짜 카운터를 불러와서 counter_num이 0이면 방문자가 하나도 없으므로 추가 아니면 기존값+1 증가되도록 수정
    	if(counter == 0) {
    		counterService.addCounter();
    	} else {
    		counterService.modifyCounter();
    	}
    }
	
	@Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println(se.getSession().getId() + " 세션이 소멸되었습니다.."); 
    	
    	// 세션이 사라질때마다 현재 접속자 수 - 1 -> application.attribute
    	ServletContext application = se.getSession().getServletContext();
    	int currentCounter = (Integer)(application.getAttribute("currentCounter"));
    	application.setAttribute("currentCounter", currentCounter-1);
    }
	
}