package com.example.demo.misc;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.seasar.doma.jdbc.QueryImplementors;
import org.seasar.doma.jdbc.entity.EntityPropertyType;
import org.seasar.doma.jdbc.entity.EntityType;
import org.seasar.doma.jdbc.entity.GeneratedIdPropertyType;
import org.seasar.doma.jdbc.entity.NamingType;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;
import org.seasar.doma.jdbc.entity.Property;
import org.seasar.doma.jdbc.entity.TenantIdPropertyType;
import org.seasar.doma.jdbc.entity.VersionPropertyType;
import org.seasar.doma.jdbc.query.AutoInsertQuery;

public class FoolishQueryImplementors implements QueryImplementors {

    @Override
    public <ENTITY> AutoInsertQuery<ENTITY> createAutoInsertQuery(final Method method,
            final EntityType<ENTITY> entityType) {
        if (method.isAnnotationPresent(Foolish.class)) {
            return new FoolishAutoInsertQuery<>(entityType);
        }
        return QueryImplementors.super.createAutoInsertQuery(method, entityType);
    }

    private static class FoolishAutoInsertQuery<ENTITY> extends AutoInsertQuery<ENTITY> {

        private final FoolishEntityTypeWrapper<ENTITY> wrapper;

        public FoolishAutoInsertQuery(final EntityType<ENTITY> entityType) {
            super(new FoolishEntityTypeWrapper<>());
            wrapper = (FoolishEntityTypeWrapper<ENTITY>) super.entityType;
        }

        @Override
        public void setEntity(final ENTITY entity) {
            wrapper.delegate = (EntityType<ENTITY>) EntityTypes.getEntityType(entity);
            super.setEntity(entity);
        }
    }

    private static class FoolishEntityTypeWrapper<ENTITY> implements EntityType<ENTITY> {

        private EntityType<ENTITY> delegate;

        @Override
        public boolean isImmutable() {
            return delegate.isImmutable();
        }

        @Override
        public String getName() {
            return delegate.getName();
        }

        @Override
        public String getCatalogName() {
            return delegate.getCatalogName();
        }

        @Override
        public String getSchemaName() {
            return delegate.getSchemaName();
        }

        @Override
        public String getTableName() {
            return delegate.getTableName();
        }

        @Override
        public String getTableName(final BiFunction<NamingType, String, String> namingFunction) {
            return delegate.getTableName(namingFunction);
        }

        @Override
        public String getQualifiedTableName() {
            return delegate.getQualifiedTableName();
        }

        @Override
        public String getQualifiedTableName(final Function<String, String> quoteFunction) {
            return delegate.getQualifiedTableName(quoteFunction);
        }

        @Override
        public String getQualifiedTableName(
                final BiFunction<NamingType, String, String> namingFunction,
                final Function<String, String> quoteFunction) {
            return delegate.getQualifiedTableName(namingFunction, quoteFunction);
        }

        @Override
        public boolean isQuoteRequired() {
            return delegate.isQuoteRequired();
        }

        @Override
        public NamingType getNamingType() {
            return delegate.getNamingType();
        }

        @Override
        public GeneratedIdPropertyType<ENTITY, ?, ?> getGeneratedIdPropertyType() {
            return delegate.getGeneratedIdPropertyType();
        }

        @Override
        public VersionPropertyType<ENTITY, ?, ?> getVersionPropertyType() {
            return delegate.getVersionPropertyType();
        }

        @Override
        public TenantIdPropertyType<ENTITY, ?, ?> getTenantIdPropertyType() {
            return delegate.getTenantIdPropertyType();
        }

        @Override
        public List<EntityPropertyType<ENTITY, ?>> getIdPropertyTypes() {
            return delegate.getIdPropertyTypes();
        }

        @Override
        public EntityPropertyType<ENTITY, ?> getEntityPropertyType(final String __name) {
            return delegate.getEntityPropertyType(__name);
        }

        @Override
        public List<EntityPropertyType<ENTITY, ?>> getEntityPropertyTypes() {
            return delegate.getEntityPropertyTypes();
        }

        @Override
        public ENTITY newEntity(final Map<String, Property<ENTITY, ?>> __args) {
            return delegate.newEntity(__args);
        }

        @Override
        public Class<ENTITY> getEntityClass() {
            return delegate.getEntityClass();
        }

        @Override
        public void saveCurrentStates(final ENTITY entity) {
            delegate.saveCurrentStates(entity);
        }

        @Override
        public ENTITY getOriginalStates(final ENTITY entity) {
            return delegate.getOriginalStates(entity);
        }

        @Override
        public void preInsert(final ENTITY entity, final PreInsertContext<ENTITY> context) {
            delegate.preInsert(entity, context);
        }

        @Override
        public void preUpdate(final ENTITY entity, final PreUpdateContext<ENTITY> context) {
            delegate.preUpdate(entity, context);
        }

        @Override
        public void preDelete(final ENTITY entity, final PreDeleteContext<ENTITY> context) {
            delegate.preDelete(entity, context);
        }

        @Override
        public void postInsert(final ENTITY entity, final PostInsertContext<ENTITY> context) {
            delegate.postInsert(entity, context);
        }

        @Override
        public void postUpdate(final ENTITY entity, final PostUpdateContext<ENTITY> context) {
            delegate.postUpdate(entity, context);
        }

        @Override
        public void postDelete(final ENTITY entity, final PostDeleteContext<ENTITY> context) {
            delegate.postDelete(entity, context);
        }
    }
}
