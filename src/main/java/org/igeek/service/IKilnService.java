package org.igeek.service;

import com.github.pagehelper.PageInfo;
import org.igeek.common.ServerResponse;
import org.igeek.pojo.Kiln;

/**
 * Created by Gyges on 2017/6/27.
 */
public interface IKilnService {

    public ServerResponse<String> updateOrSaveKilnValue(Kiln kiln);

    public ServerResponse<PageInfo> listAllKiln(int pageNum, int pageSize);

    public ServerResponse<String> updateStatus(Integer kilnId, String status);

}
