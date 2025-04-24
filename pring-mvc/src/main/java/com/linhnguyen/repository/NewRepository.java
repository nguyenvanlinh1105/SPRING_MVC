package com.linhnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linhnguyen.entity.NewEntity;


public interface NewRepository extends JpaRepository<NewEntity, Long> {
	// JpaRepository: T:Entity đang làm việc , Serializable: khai báo kiểu dữ liệu của khóa chính của entity đang làm vc.
	// có thể custome repository
	// khi extends JpaRepository thì đã có @Repository nên ta không cần khai báo ở trên class
	// và NewRepository chỉ cần Interface không cần class vì trogn JpaRepository đã có hết tất cả class hỗ trợ việc insert, update, delete dữ liệu.
}
