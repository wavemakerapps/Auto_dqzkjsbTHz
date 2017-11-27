/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_dqzkjsbthz.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.auto_dqzkjsbthz.hrdb.Department;
import com.auto_dqzkjsbthz.hrdb.Employee;

/**
 * Service object for domain model class {@link Department}.
 */
public interface DepartmentService {

    /**
     * Creates a new Department. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Department if any.
     *
     * @param department Details of the Department to be created; value cannot be null.
     * @return The newly created Department.
     */
	Department create(@Valid Department department);


	/**
	 * Returns Department by given id if exists.
	 *
	 * @param departmentId The id of the Department to get; value cannot be null.
	 * @return Department associated with the given departmentId.
     * @throws EntityNotFoundException If no Department is found.
	 */
	Department getById(Integer departmentId) throws EntityNotFoundException;

    /**
	 * Find and return the Department by given id if exists, returns null otherwise.
	 *
	 * @param departmentId The id of the Department to get; value cannot be null.
	 * @return Department associated with the given departmentId.
	 */
	Department findById(Integer departmentId);

    /**
	 * Find and return the Department for given deptCode  if exists.
	 *
	 * @param deptCode value of deptCode; value cannot be null.
	 * @return Department associated with the given inputs.
     * @throws EntityNotFoundException if no matching Department found.
	 */
    Department getByDeptCode(String deptCode)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Department. It replaces all fields of the existing Department with the given department.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Department if any.
     *
	 * @param department The details of the Department to be updated; value cannot be null.
	 * @return The updated Department.
	 * @throws EntityNotFoundException if no Department is found with given input.
	 */
	Department update(@Valid Department department) throws EntityNotFoundException;

    /**
	 * Deletes an existing Department with the given id.
	 *
	 * @param departmentId The id of the Department to be deleted; value cannot be null.
	 * @return The deleted Department.
	 * @throws EntityNotFoundException if no Department found with the given id.
	 */
	Department delete(Integer departmentId) throws EntityNotFoundException;

	/**
	 * Find all Departments matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Departments.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Department> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Departments matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Departments.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Department> findAll(String query, Pageable pageable);

    /**
	 * Exports all Departments matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Departments in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Department.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated employees for given Department id.
     *
     * @param deptId value of deptId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Employee instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Employee> findAssociatedEmployees(Integer deptId, Pageable pageable);

}

