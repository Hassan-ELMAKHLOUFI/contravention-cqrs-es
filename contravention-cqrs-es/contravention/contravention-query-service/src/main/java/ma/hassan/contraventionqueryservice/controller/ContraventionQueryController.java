package ma.hassan.contraventionqueryservice.controller;

import ma.hassan.contraventionqueryservice.entities.Contravention;
import ma.hassan.coreapi.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/contraventions")
public class ContraventionQueryController {

    @Autowired
    public QueryGateway queryGateway ;


    @GetMapping
    public CompletableFuture<List<Contravention>> contraventionList(){
        System.out.println("******************************************");
        return  queryGateway.query(new GetAllContraventions(), ResponseTypes.multipleInstancesOf(Contravention.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Contravention> contravention(@PathVariable String id ){
        return  queryGateway.query(new GetContraventionById(id), ResponseTypes.instanceOf(Contravention.class));
    }


    @GetMapping("/owner/{owner}")
    public CompletableFuture<List<Contravention>> contraventionsByOwner(@PathVariable String owner){
        return  queryGateway.query(new GetContraventionByOwner(owner), ResponseTypes.multipleInstancesOf(Contravention.class));
    }

    @GetMapping("/owners")
    public CompletableFuture<List<Owner>> owner(){
        return  queryGateway.query(new GetAllOwners(), ResponseTypes.multipleInstancesOf(Owner.class));
    }

    @GetMapping("/owners/{id}")
    public CompletableFuture<Owner> ownerById(@PathVariable String id){
        return  queryGateway.query(new GetOwnerById(id), ResponseTypes.instanceOf(Owner.class));
    }

}
