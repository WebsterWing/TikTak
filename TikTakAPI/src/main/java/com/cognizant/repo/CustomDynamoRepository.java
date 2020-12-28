package com.cognizant.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.datamodeling.QueryResultPage;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.cognizant.model.SingleTableModel;

@ComponentScan
public class CustomDynamoRepository<T extends SingleTableModel> {
	private String pkPrefix;
	private String skPrefix;

	private T instance;
	
	@Autowired
	private DynamoDBMapper mapper;

	public CustomDynamoRepository(T instance) {
		this.instance = instance;
		pkPrefix = instance.getPkPrefix();
		skPrefix = instance.getSkPrefix();
	}

	/*
	public QueryResultPage<T> findAll() {
		return findAll(null);
	}
	*/

	/*
	public QueryResultPage<T> findAll(Map<String, AttributeValue> exclusiveStartKey) {
		String query = "begins_with(PK, :pk_prefix) and begins_with(SK, :sk_prefix)";
		
		HashMap values = new HashMap<String, AttributeValue>();
		
		values.put(":pk_prefix", new AttributeValue().withS(pkPrefix));
		values.put(":sk_prefix", new AttributeValue().withS(skPrefix));

        DynamoDBQueryExpression<T> queryExpression = new DynamoDBQueryExpression<T>(
        		).withKeyConditionExpression(
        				query
                ).withExpressionAttributeValues(values);
        
        if (exclusiveStartKey != null) {
        	queryExpression.setExclusiveStartKey(exclusiveStartKey);
        }

        @SuppressWarnings("unchecked")
		QueryResultPage<T> results = mapper.queryPage((Class<T>) instance.getClass(), queryExpression);
        return results;
    }
    */

	/*
	public QueryResultPage<T> findAll(Map<String, AttributeValue> exclusiveStartKey) {
		String query = "begins_with(PK, :pk_prefix) and begins_with(SK, :sk_prefix)";
		
		HashMap values = new HashMap<String, AttributeValue>();
		
		values.put(":pk_prefix", new AttributeValue().withS(pkPrefix));
		values.put(":sk_prefix", new AttributeValue().withS(skPrefix));

        ScanRequest scanExpression = new ScanRequest(
        		).withFilterExpression(
        				query
                ).withExpressionAttributeValues(values);
        
        if (exclusiveStartKey != null) {
        	scanExpression.setExclusiveStartKey(exclusiveStartKey);
        }

        @SuppressWarnings("unchecked")
		QueryResultPage<T> results = mapper.queryPage((Class<T>) instance.getClass(), queryExpression);
        return results;
    }
    */
}
