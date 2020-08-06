package com.example.demo.Dao;


import com.example.demo.PangDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<PangDto> list() {
        return sqlSession.selectList("test.testBoardList");
    }

    @Override
    public PangDto detail(int boardNum) {
        return sqlSession.selectOne("test.detail",boardNum);
    }

    @Override
    public void delete(int boardNum) {

        sqlSession.delete("test.delete",boardNum);
    }

    @Override
    public void write(PangDto pangDto) {

        sqlSession.insert("test.write",pangDto);
    }

    @Override
    public void hit(PangDto pangDto) {

        sqlSession.update("test.hit",pangDto);
    }
}
