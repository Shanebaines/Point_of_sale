package com.ProjectSpringboot.Point_of_sale.controller;

import com.ProjectSpringboot.Point_of_sale.dto.paginated.PaginatedResponseItemDto;
import com.ProjectSpringboot.Point_of_sale.dto.request.ItemDTO;
import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import com.ProjectSpringboot.Point_of_sale.service.ItemService;
import com.ProjectSpringboot.Point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDTO itemDTO) {
        String message = itemService.saveItem(itemDTO);
        return ResponseEntity.ok(new StandardResponse(200, message, null));
    }

    @GetMapping(path = "/get-by-name", params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOs = itemService.getItemByNameAndStatus(itemName);
        return ResponseEntity.ok(new StandardResponse(200, "Items fetched successfully", itemDTOs));
    }

    @PatchMapping("/update-active-state/{itemId}")
    public ResponseEntity<StandardResponse> updateActiveState(
            @PathVariable String itemId,
            @RequestParam boolean activeState) {
        String result = itemService.updateActiveState(itemId, activeState);
        return ResponseEntity.ok(new StandardResponse(200, result, null));
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemGetResponseDTO> itemDTOs = itemService.getAllItems();
        return ResponseEntity.ok(new StandardResponse(200, "Items fetched successfully", itemDTOs));
    }

    @GetMapping(path = "/get-all-item-by-status", params = {"activeStatus", "page", "size"})
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        PaginatedResponseItemDto result = itemService.getItemsByActiveStatusWithPagination(activeStatus, page, size);
        return ResponseEntity.ok(new StandardResponse(200, "Items fetched successfully", result));
    }
}
