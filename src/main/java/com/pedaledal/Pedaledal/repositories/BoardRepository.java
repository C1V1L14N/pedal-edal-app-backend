package com.pedaledal.Pedaledal.repositories;

import com.pedaledal.Pedaledal.models.boards.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findBoardBySaveNameIgnoreCase(String saveName);
    List<Board> findBoardByUserNameIgnoreCase(String userName);
}
