package com.pedaledal.Pedaledal.controllers;

import com.pedaledal.Pedaledal.models.boards.Board;
import com.pedaledal.Pedaledal.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping(value = "/boards")
    public ResponseEntity<List<Board>> getAllBoardsWithFilter(
            @RequestParam(name = "boardSaveName", required = false) String boardSaveName){
        if (boardSaveName != null){
            return new ResponseEntity<>(boardRepository.findBoardBySaveNameIgnoreCase(boardSaveName), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(boardRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/animals/users")
//    public ResponseEntity<List<User>> findAnimalsForUsersNamedQuery(
//            @RequestParam(name = "username") String username){
//        return new ResponseEntity(animalRepository.findAnimalByUserUserName(username), HttpStatus.OK);
//    }

    @GetMapping(value = "/boards/{id}")
    public ResponseEntity getBoard(@PathVariable Long id){
        return new ResponseEntity(boardRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/boards")
    public ResponseEntity<Board> postBoard(@RequestBody Board board){
        boardRepository.save(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/boards/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id){
        Board found = boardRepository.getOne(id);
        boardRepository.delete(found);
        return new ResponseEntity(boardRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/boards/{id}")
    public ResponseEntity<Board> putBoard(@RequestBody Board board, @PathVariable Long id){
        Board boardToUpdate = boardRepository.findById(id).get();
        board.setSaveName(board.getSaveName());
        board.setWidth(board.getWidth());
        board.setDepth(board.getDepth());
        board.setHeight(board.getHeight());
        board.setBoardPedals(board.getBoardPedals());
        board.setUser(board.getUser());
        boardRepository.save(boardToUpdate);
        return new ResponseEntity<>(boardToUpdate, HttpStatus.OK);
    }
}
