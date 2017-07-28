package org.colorcoding.ibas.feedback.test.bo;

import junit.framework.TestCase;
import org.colorcoding.ibas.bobas.data.*;
import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.repository.*;
import org.colorcoding.ibas.feedback.data.*;
import org.colorcoding.ibas.feedback.bo.suggestion.*;
import org.colorcoding.ibas.feedback.repository.*;

/**
* 建议 测试
* 
*/
public class testSuggestion extends TestCase {
    /**
     * 获取连接口令
    */
    String getToken() {
        return "";
    }
    
    /**
     * 基本项目测试
     * @throws Exception 
    */
    public void testBasicItems() throws Exception {
        Suggestion bo = new Suggestion();
        // 测试属性赋值


        // 测试对象的保存和查询
        IOperationResult<?> operationResult = null;
        ICriteria criteria = null;
        IBORepositoryFeedbackApp boRepository = new BORepositoryFeedback();
        //设置用户口令
        boRepository.setUserToken(this.getToken());

        // 测试保存
        operationResult = boRepository.saveSuggestion(bo);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);
        Suggestion boSaved = (Suggestion)operationResult.getResultObjects().firstOrDefault();


        // 测试查询
        criteria = boSaved.getCriteria();
        criteria.setResultCount(10);
        operationResult = boRepository.fetchSuggestion(criteria);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);


    }

}
