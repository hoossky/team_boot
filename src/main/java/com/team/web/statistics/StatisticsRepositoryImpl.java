package com.team.web.statistics;

import static com.team.web.statistics.QStatistics.statistics;

import antlr.Parser;
import antlr.StringUtils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import java.util.List;
import java.util.Map;

@Repository
interface IStatisticsRepository{
    Map<?,?> test();
    List<AvgRainVO> avgRain();
    List<AvgRainVO> rainProb();


}
public class StatisticsRepositoryImpl extends QuerydslRepositorySupport implements IStatisticsRepository{
    private final JPAQueryFactory queryFactory;

    public StatisticsRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Statistics.class);
        this.queryFactory = queryFactory;
    }



    @Override
    public Map<?, ?> test() {
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Long ts = queryFactory.select(statistics.precipitationDate).from(statistics)
                .where(statistics.precipitationDate.like("%"+"08-15"+"%"))
                .fetchCount();

        System.out.println(ts.toString());
        return null;
    }
    @Override
    public List<AvgRainVO> avgRain() {

       // List<String> list = from(statistics).select(statistics.precipitationDate).fetch();

    /*    long a= from(statistics).select(statistics).where(statistics.rain.isNull().and(statistics.precipitationDate.like( list.get(0)))).fetchCount();
        long b = from(statistics).select(statistics).where(statistics.precipitationDate.like( list.get(0))).fetchCount();
        System.out.println(a);
        System.out.println(b);
        double probability= a/b;
        System.out.println(probability);*/
        return queryFactory.select(Projections.fields(AvgRainVO.class,
                statistics.precipitationDate,statistics.precipitationDaily.avg().as("avgRain")))
                .from(statistics)
                .groupBy(statistics.precipitationDate).fetch();
    }





    /*SELECT PRECIPITATION_DATE,SUM(rain)*100/COUNT(PRECIPITATION_DATE) AS PB_RAIN,
 AVG(PRECIPITATION_DAILY) AS AVG_RAIN
 FROM statistics
 GROUP BY PRECIPITATION_DATE*/

  //  @Query("select new com.team.web.statistics(statistic.precipitationDate,SUM (statistic.rain)*100/count(statistic.precipitationDate)as AvgRainVO rainProb) ")
    public List<AvgRainVO> rainProb() {
        return queryFactory.select(Projections.fields(
                AvgRainVO.class, statistics.precipitationDate, statistics.pbRain.as("rainProb")
        )).from(statistics).groupBy(statistics.precipitationDate).fetch();



//        return null/*queryFactory.select(Projections.fields(AvgRainVO.class,
//                statistics.precipitationDate,
//                (statistics.rain.sum())/(statistics.precipitationDate.count()).as("rainProb")))
//                .from(statistics)
//                .groupBy(statistics.precipitationDate).fetch()*/;

    }


       /*
        JPAQuery query = new JPAQuery(entityManager);

        List<Integer> list = from(statistics).select(statistics.rain.sum()).fetch();
        System.out.println(list.get(0));
        System.out.println(Double.valueOf(list.get(0) * 1.0/21.0));*/
      /*  Long count = from(statistics).select(statistics.rain.eq(1)).fetchCount();
        Long sum = from(statistics).select(statistics.rain.sum());

        int i = queryFactory.select(statistics.rain.sum()).from(statistics);*/

       /* System.out.println(from(statistics).select(statistics.rain.sum()).fetch()/(from(statistics).select(statistics.precipitationDate).fetchCount())*100.0;
        Double a = queryFactory.select(Projections.fields(AvgRainVO.class,
                statistics.precipitationDate,
                .as("rainProb")));*/
     /*   long b=from(statistics).fetchCount();
        long total=(a/b)*100;
        System.out.println("total :"+ total);*/
//        System.out.println(from(statistics).select(statistics.rain.sum()).fetchOne());


    /*SELECT PRECIPITATION_DATE,SUM(rain)*100/COUNT(PRECIPITATION_DATE) AS PB_RAIN,
 AVG(PRECIPITATION_DAILY) AS AVG_RAIN
 FROM statistics
 GROUP BY PRECIPITATION_DATE*/

    /*SELECT statistics.precipitation_date,
AVG(statistics.precipitation_daily) AS AVG_RAIN
 FROM statistics
GROUP BY statistics.precipitation_date
ORDER BY statistics.precipitation_date ASC*/

     /*SELECT a.PRECIPITATION_DATE, A.PB_RAIN, B.AVG_RAIN FROM
(

SELECT PRECIPITATION_DATE, COUNT(*), SUM(IF(rain = FALSE, 0, 1))*100/COUNT(*) AS PB_RAIN
 FROM statistics
 GROUP BY PRECIPITATION_DATE
) A,
(
SELECT statistics.precipitation_date,
AVG(statistics.precipitation_daily) AS AVG_RAIN
 FROM statistics
GROUP BY statistics.precipitation_date
ORDER BY statistics.precipitation_date ASC
) B
WHERE A.PRECIPITATION_DATE = B.precipitation_date*/

 /*   @Override
    public List<Statistics> findAllrain() {
        return queryFactory.select(Projections.fields(AvgRainVO.class,
                statistics.precipitationDate.as("rainProb"),
                ExpressionUtils.as(
                        JPAExpressions.select(count())
                        .from(statistics)
                        .groubBy(statistics.precipitationDate)
                )));
    }*/

 /*SELECT a.PRECIPITATION_DATE, A.PB_RAIN, B.AVG_RAIN FROM
(

SELECT PRECIPITATION_DATE, COUNT(*), SUM(IF(rain = FALSE, 0, 1))*100/COUNT(*) AS PB_RAIN
 FROM statistics
 GROUP BY PRECIPITATION_DATE
) A,
(
SELECT statistics.precipitation_date,
AVG(statistics.precipitation_daily) AS AVG_RAIN
 FROM statistics
GROUP BY statistics.precipitation_date
ORDER BY statistics.precipitation_date ASC
) B
WHERE A.PRECIPITATION_DATE = B.precipitation_date*/



}
