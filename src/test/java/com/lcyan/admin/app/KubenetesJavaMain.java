package com.lcyan.admin.app;

import com.google.gson.Gson;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.util.ClientBuilder;

public class KubenetesJavaMain {

    public static void main(String[] args) throws ApiException {
        ApiClient client = new ClientBuilder().setBasePath("https://172.31.6.164:6443").setVerifyingSsl(false)
                //.setAuthentication(new AccessTokenAuthentication("Token"))
                .build();
        Configuration.setDefaultApiClient(client);
        /**
        CustomObjectsApi apiInstance = new CustomObjectsApi();
        String group = "batch";
        String version = "v1";
        String plural = "jobs";
        String pretty = "ture";
        try {
            Object result = apiInstance.listClusterCustomObject(group,version,plural,pretty,null,null,null,null);
            String listCluster = JSON.toJSONString(result);
            System.out.println(listCluster);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomObjectsApi#listClusterCustomObject");
            e.printStackTrace();
        }*/
        CoreV1Api apiInstance = new CoreV1Api();
        String pretty = null; // String | If 'true', then the output is pretty printed.
        Boolean allowWatchBookmarks = true; // Boolean | allowWatchBookmarks requests watch events with type \"BOOKMARK\". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.  This field is beta.
        String _continue = null; // String | The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \"next key\".  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
        String fieldSelector = null; // String | A selector to restrict the list of returned objects by their fields. Defaults to everything.
        String labelSelector = null; // String | A selector to restrict the list of returned objects by their labels. Defaults to everything.
        Integer limit = null; // Integer | limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
        String resourceVersion = null; // String | When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
        Integer timeoutSeconds = null; // Integer | Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
        Boolean watch = null;

        //V1NamespaceList result = apiInstance.listNamespace(allowWatchBookmarks, pretty, _continue, fieldSelector, labelSelector, limit, resourceVersion, timeoutSeconds, watch);
       // String listCluster = JSON.toJSONString(result);
       // System.out.println(listCluster);
        // Node列表
        //V1NodeList result01 = apiInstance.listNode(null,pretty,null,null,null,null,null,null,null);
        //System.out.println(result01);
        //String listNode = JSON.toJSONString(result01);
       //System.out.println(listNode);
        // Service列表
        V1ServiceList v1ServiceList = apiInstance.listNamespacedService("kube-system", null, pretty, null, null, null, null, null, null, null);
        //System.out.println(v1ServiceList);
        // JSON
        Gson gson=new Gson();
        String listService = gson.toJson(v1ServiceList);
        //System.out.println(listService);
        // Service 详情
        // /api/v1/namespaces/kube-system/services/webapi-service
        // V1Service result = apiInstance.readNamespacedService("flyapi-service", "kube-system", null, null, null);
        V1PodList v1PodList = apiInstance.listNamespacedPod("default", null, pretty, null, null, null, null, null, null, null);
        //String pods = gson.toJson(v1PodList);
        //System.out.println(pods);
        V1PodList v1PodList1 = apiInstance.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        System.out.println(v1PodList1);
        //String pods = gson.toJson(v1PodList1);
        //System.out.println(pods);
        for (V1Pod item : v1PodList1.getItems()) {
            //System.out.println(item);
            //System.out.println(item.getMetadata().getName());
        }
        //System.out.println(pods);
    }
}
