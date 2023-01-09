package kg.megacom.NaTv.controller;

import com.sun.org.apache.xpath.internal.operations.Mult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.NaTv.models.dto.ChannelsDto;
import kg.megacom.NaTv.models.repository.ChannelsRepository;
import kg.megacom.NaTv.services.ChannelsServices;
import kg.megacom.NaTv.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/chan")
@Api(tags = Swagger2Config.Channel)
public class ChannelsController {

    @Autowired
    private ChannelsServices services;


//    @PostMapping("/save")
//    public ResponseEntity<?>save(@RequestBody ChannelsDto channelsDto){
//        try{
//            return ResponseEntity.ok(services.save(channelsDto));
//        }catch (Exception e){
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
//        }
//
//    }

    @PostMapping("/save/all")
    @ApiOperation(value = "Сохранение канала")
        public ResponseEntity<?>saveAll(@RequestParam String name,
                                        @RequestParam int orderNum,
                                        @RequestParam(value = "isActive", required = false) boolean isActive,
                                        @RequestPart MultipartFile multipartFile)
                                                    {
        try {
            return ResponseEntity.ok(services.saveAll(name,orderNum,multipartFile,isActive));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/fid")
    @ApiOperation(value = "Вывести все каналы")
    public ResponseEntity<?>fidAll(){
        try{
            return ResponseEntity.ok(services.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/rep")
    @ApiOperation(value = "Пагинация")

    public ResponseEntity<?>channelsResponseTest(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "sort_by_order_num", required = false) boolean sortByOrderNum) {
        try{
            return ResponseEntity.ok(services.channelsResponseTest(page, size, sortByOrderNum));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Фильтрация по: 1)name  2)price  3)orderNum  4)percent")

    public ResponseEntity<?>channelsResponseTest(@RequestParam(value = "Filter", required = false) String filter){
        try {
            return ResponseEntity.ok(services.filtration(filter));
            }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
