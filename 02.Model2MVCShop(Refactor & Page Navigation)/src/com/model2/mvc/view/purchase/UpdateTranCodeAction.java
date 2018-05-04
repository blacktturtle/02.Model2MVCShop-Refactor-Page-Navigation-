package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PurchaseService purchaseService = new PurchaseServiceImpl();
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		System.out.println("UpdateTranCode 받아온 ProdNo ::" + prodNo);
		
		Purchase purchase =  purchaseService.getPurchase2(prodNo);		
		System.out.println("UpdateTranCode 받아온 TranCode ::" + purchase.getTranCode());
		
		purchase.setTranCode("2");
		
		
		purchaseService.updateTranCode(purchase);
		
		
		return "forward:/listProduct.do?menu=manage";
	}

}
