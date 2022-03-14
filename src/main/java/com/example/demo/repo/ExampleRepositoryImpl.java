package com.example.demo.repo;

import com.example.demo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ExampleRepositoryImpl implements ExampleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Example> findOnlyUnique(String column) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Example> cQuery = criteriaBuilder.createQuery(Example.class);
        Subquery<Example> subQuery = criteriaBuilder.createQuery().subquery(Example.class);
        Root<Example> root = cQuery.from(Example.class);
        Root<Example> sRoot = subQuery.from(Example.class);

        subQuery.select(sRoot.get(column))
                .groupBy(sRoot.get(column))
                .having(criteriaBuilder.lt(criteriaBuilder.count(sRoot.get(column)), 2));

        cQuery.select(root)
                .where(root.get(column).in(subQuery));

        return em.createQuery(cQuery).getResultList();
    }

    @Override
    public List<Example> findOnlyDuplicate(String column) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Example> cQuery = criteriaBuilder.createQuery(Example.class);
        Subquery<Example> subQuery = criteriaBuilder.createQuery().subquery(Example.class);
        Root<Example> root = cQuery.from(Example.class);
        Root<Example> subRoot = subQuery.from(Example.class);

        subQuery.select(subRoot.get(column))
                .groupBy(subRoot.get(column))
                .having(criteriaBuilder.gt(criteriaBuilder.count(subRoot.get(column)), 1));

        cQuery.select(root)
                .where(root.get(column).in(subQuery));

        return em.createQuery(cQuery).getResultList();
    }
}
