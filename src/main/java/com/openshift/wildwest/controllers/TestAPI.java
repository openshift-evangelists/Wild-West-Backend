package com.openshift.wildwest.controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

@RestController
public class TestAPI {

	private OpenShiftClient client;

	// oc policy add-role-to-user view system:serviceaccount:wildwest:default where wildwest
	// is the project name

	// To enable destructive mode, a different permission needs to be added
	// oc policy add-role-to-user edit system:serviceaccount:wildwest:default

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