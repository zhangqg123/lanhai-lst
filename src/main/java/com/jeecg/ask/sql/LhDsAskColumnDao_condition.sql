		<#if ( lhDsAskColumn.id )?? && lhDsAskColumn.id ?length gt 0>
		    /* id */
			and ldac.ID = :lhDsAskColumn.id
		</#if>
		<#if ( lhDsAskColumn.imageHref )?? && lhDsAskColumn.imageHref ?length gt 0>
		    /* 图片地址 */
			and ldac.IMAGE_HREF = :lhDsAskColumn.imageHref
		</#if>
		<#if ( lhDsAskColumn.imageName )?? && lhDsAskColumn.imageName ?length gt 0>
		    /* 图片名称 */
			and ldac.IMAGE_NAME = :lhDsAskColumn.imageName
		</#if>
		<#if ( lhDsAskColumn.columnName )?? && lhDsAskColumn.columnName ?length gt 0>
		    /* 类别名称 */
			and ldac.COLUMN_NAME = :lhDsAskColumn.columnName
		</#if>
		<#if ( lhDsAskColumn.type )?? && lhDsAskColumn.type ?length gt 0>
		    /* 类型 */
			and ldac.TYPE = :lhDsAskColumn.type
		</#if>
		<#if ( lhDsAskColumn.parentCode )?? && lhDsAskColumn.parentCode ?length gt 0>
		    /* 父节点 */
			and ldac.PARENT_CODE = :lhDsAskColumn.parentCode
		</#if>
		<#if ( lhDsAskColumn.href )?? && lhDsAskColumn.href ?length gt 0>
		    /* 地址 */
			and ldac.HREF = :lhDsAskColumn.href
		</#if>
		<#if ( lhDsAskColumn.owner )?? && lhDsAskColumn.owner ?length gt 0>
		    /* 所有人 */
			and ldac.OWNER = :lhDsAskColumn.owner
		</#if>
