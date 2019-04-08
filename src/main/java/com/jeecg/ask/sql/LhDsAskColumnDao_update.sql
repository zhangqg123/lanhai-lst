UPDATE lh_ds_ask_column
SET 
	   <#if lhDsAskColumn.id ?exists>
		   ID = :lhDsAskColumn.id,
		</#if>
	   <#if lhDsAskColumn.imageHref ?exists>
		   IMAGE_HREF = :lhDsAskColumn.imageHref,
		</#if>
	   <#if lhDsAskColumn.imageName ?exists>
		   IMAGE_NAME = :lhDsAskColumn.imageName,
		</#if>
	   <#if lhDsAskColumn.columnName ?exists>
		   COLUMN_NAME = :lhDsAskColumn.columnName,
		</#if>
	   <#if lhDsAskColumn.type ?exists>
		   TYPE = :lhDsAskColumn.type,
		</#if>
	   <#if lhDsAskColumn.parentCode ?exists>
		   PARENT_CODE = :lhDsAskColumn.parentCode,
		</#if>
	   <#if lhDsAskColumn.href ?exists>
		   HREF = :lhDsAskColumn.href,
		</#if>
	   <#if lhDsAskColumn.owner ?exists>
		   OWNER = :lhDsAskColumn.owner,
		</#if>
WHERE id = :lhDsAskColumn.id