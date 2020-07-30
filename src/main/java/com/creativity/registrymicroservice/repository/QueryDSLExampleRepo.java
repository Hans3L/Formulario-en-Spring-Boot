package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.entity.CourseEntity;
import com.creativity.registrymicroservice.entity.QCourseEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("queryDLSExample")
public class QueryDSLExampleRepo {

    private QCourseEntity qCourseEntity = QCourseEntity.courseEntity;

    @PersistenceContext
    private EntityManager entityManager;

    public CourseEntity find(boolean exist) {

        JPAQuery<CourseEntity> query = new JPAQuery<>(entityManager);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourseEntity.description.endsWith("OP"));

        if (exist) {
            Predicate predicate2 = qCourseEntity.id.eq(23);
            predicateBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourseEntity.name.endsWith("vel");
            predicateBuilder.or(predicate3);
        }
        return query.select(qCourseEntity).from(qCourseEntity).where(predicateBuilder).fetchOne();
    }
}