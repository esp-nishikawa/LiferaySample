package jp.co.esp.sample.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import jp.co.esp.sample.service.ClpSerializer;
import jp.co.esp.sample.service.HomeLocalServiceUtil;
import jp.co.esp.sample.service.HomeServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            HomeLocalServiceUtil.clearService();

            HomeServiceUtil.clearService();
        }
    }
}
