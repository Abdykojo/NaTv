package kg.megacom.NaTv.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.request.OrderRequest;
import kg.megacom.NaTv.services.OrdersServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ord")
@Api(tags = Swagger2Config.Ord)
public class OrdersController {
    @Autowired
    private OrdersServices services;

//    @PostMapping("/save")
//    public ResponseEntity<?> save(@RequestBody OrdersDto ordersDto){
//        try{
//            return ResponseEntity.ok(services.save(ordersDto));
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
//        }
 //   }
    @PostMapping("/kkk")
    @ApiOperation(value = "Создание заявки")
    public ResponseEntity<?>channelsList(@RequestBody OrderRequest request){
        try {
            return ResponseEntity.ok(services.saveOrder(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
