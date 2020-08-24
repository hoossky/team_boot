package com.team.web.izzifile;

import com.team.web.statistics.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface IzziFileRepository extends JpaRepository<IzziFileDB, String> {

}
