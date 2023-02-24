//package com.tk.tkgraphqlbackend.Subscriptions;
//
//import com.tk.tkgraphqlbackend.model.Patient;
//import graphql.kickstart.tools.GraphQLSubscriptionResolver;
//import org.reactivestreams.Publisher;
//import org.springframework.stereotype.Controller;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.FluxSink;
//
//import java.util.concurrent.ConcurrentHashMap;
//@Controller
//public class Subscription implements GraphQLSubscriptionResolver {
//
//    private ConcurrentHashMap<Long, FluxSink<Patient>> subscribers = new ConcurrentHashMap<>();
//
//    public Publisher<Patient> onPatientUpdate(Long id){
//        return Flux.create(subscriber-> subscribers.put(id,subscriber.onDispose(()->subscribers.
//                remove(id, subscriber))),FluxSink.OverflowStrategy.LATEST);
//    }
//}
