package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeByProdAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PurchaseService purchaseService = new PurchaseServiceImpl();
		
		int tranNo = Integer.parseInt(request.getParameter("tranNo"));
		System.out.println("UpdateTranCode 받아온 tranNo ::" + tranNo);
		
		Purchase purchase =  purchaseService.getPurchase(tranNo);		
		System.out.println("UpdateTranCode 받아온 TranCode ::" + purchase.getTranCode());
		
		purchase.setTranCode("3");
		
		
		purchaseService.updateTranCode(purchase);
		
		
		return "forward:/listPurchase.do";
	}

}
