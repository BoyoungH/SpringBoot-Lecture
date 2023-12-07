package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> cateogries = new ArrayList<Category>();

    //==비즈니스 로직==//
    public void addStockQuantity(int quantity){
        this.stockQuantity += quantity;
    }

    public void removeStockQuantity(int quantity){
        int realStock = this.stockQuantity - quantity;
        if(realStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = realStock;
    }
}
