package com.openshift.kwww.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openshift.kwww.models.Game;
import com.openshift.kwww.models.Score;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

@RestController
public class TestAPI {
	
	private OpenShiftClient client;
    
    // oc policy add-role-to-user view system:serviceaccount:kwww:default  where kwww is the project name
    @RequestMapping("/kube")
    public Hashtable getPlatformObjects() {
    	client = new DefaultOpenShiftClient();
    	List<Pod> pods = null;
    	PodList theList = client.pods().list();
    	ArrayList arrayList = new ArrayList();
    	Hashtable hashtable = new Hashtable<>();
    	pods = theList.getItems();
    	
    	for (Pod currPod : pods) {
    		hashtable.put(currPod.getMetadata().getUid(), currPod.getMetadata().getName());
    	}
    	
    	return hashtable;
    	
    }
}