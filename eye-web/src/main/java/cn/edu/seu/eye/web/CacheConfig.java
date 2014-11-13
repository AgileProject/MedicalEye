package cn.edu.seu.eye.web;

import net.sf.ehcache.CacheException;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.interceptor.DefaultKeyGenerator;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
@EnableCaching(proxyTargetClass = true)
public class CacheConfig implements CachingConfigurer {

	@Bean
	public EhCacheFactoryBean sessionCaching() {
		EhCacheFactoryBean ehCacheManagerFactoryBean = new EhCacheFactoryBean();
		ehCacheManagerFactoryBean.setCacheName("sessionCaching");
		ehCacheManagerFactoryBean.setCacheManager(ehCacheManager());
		return ehCacheManagerFactoryBean;
	}

	@Bean
	public EhCacheFactoryBean systemCaching() {
		EhCacheFactoryBean ehCacheManagerFactoryBean = new EhCacheFactoryBean();
		ehCacheManagerFactoryBean.setCacheName("systemCaching");
		ehCacheManagerFactoryBean.setCacheManager(ehCacheManager());
		return ehCacheManagerFactoryBean;
	}

	@Bean(destroyMethod = "shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager() {
		// net.sf.ehcache.CacheManager ehcacheManager = new net.sf.ehcache.CacheManager(new ClassPathResource("ehcache.xml").getInputStream());
		// CacheConfiguration cacheConfiguration = new CacheConfiguration();
		// cacheConfiguration.setName("myCacheName");
		// cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
		// cacheConfiguration.setMaxEntriesLocalHeap(1000);

		// net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		// config.addCache(cacheConfiguration);

		try {
			return net.sf.ehcache.CacheManager.newInstance(new ClassPathResource("ehcache.xml").getInputStream());
		} catch (CacheException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new DefaultKeyGenerator();
	}
}
