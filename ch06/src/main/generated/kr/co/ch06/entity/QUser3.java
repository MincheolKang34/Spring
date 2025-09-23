package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser3 is a Querydsl query type for User3
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser3 extends EntityPathBase<User3> {

    private static final long serialVersionUID = 1506575589L;

    public static final QUser3 user3 = new QUser3("user3");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath hp = createString("hp");

    public final StringPath name = createString("name");

    public final StringPath user_id = createString("user_id");

    public QUser3(String variable) {
        super(User3.class, forVariable(variable));
    }

    public QUser3(Path<? extends User3> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser3(PathMetadata metadata) {
        super(User3.class, metadata);
    }

}

