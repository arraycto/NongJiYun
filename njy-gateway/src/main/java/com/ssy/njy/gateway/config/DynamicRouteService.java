package com.ssy.njy.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 动态更新路由网关service
 * 1）实现一个Spring提供的事件推送接口ApplicationEventPublisherAware
 * 2）提供动态路由的基础方法，可通过获取bean操作该类的方法。该类提供新增路由、更新路由、删除路由，然后实现发布的功能。
 *
 * @author: mqxu
 * @date: 2021-07-27
 */
@Slf4j
@Service
public class DynamicRouteService implements ApplicationEventPublisherAware {
    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;
    @Resource
    private RouteDefinitionLocator routeDefinitionLocator;
    /**
     * 发布事件
     */
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 删除路由
     *
     * @param id id
     */
    public void delete(String id) {
        try {
            log.info("gateway delete route id {}", id);
            this.routeDefinitionWriter.delete(Mono.just(id)).subscribe();
            this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 更新路由
     *
     * @param definitions 路由定义列表
     */
    public void updateList(List<RouteDefinition> definitions) {
        log.info("gateway update route {}", definitions);
        // 删除缓存routerDefinition
        List<RouteDefinition> routeDefinitionsExits = routeDefinitionLocator.getRouteDefinitions().buffer().blockFirst();
        if (!CollectionUtils.isEmpty(routeDefinitionsExits)) {
            Objects.requireNonNull(routeDefinitionsExits).forEach(routeDefinition -> {
                log.info("delete routeDefinition:{}", routeDefinition);
                delete(routeDefinition.getId());
            });
        }
        definitions.forEach(this::updateById);
    }

    /**
     * 更新路由
     *
     * @param definition 路由定义
     */
    public void updateById(RouteDefinition definition) {
        try {
            log.info("gateway update route {}", definition);
            this.routeDefinitionWriter.delete(Mono.just(definition.getId()));
        } catch (Exception e) {
            definition.getId();
            return;
        }
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 增加路由
     *
     * @param definition 路由定义
     */
    public void add(RouteDefinition definition) {
        log.info("gateway add route {}", definition);
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
    }
}
