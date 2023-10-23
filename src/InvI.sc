;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Class_255_0)
(use IconI)
(use SysWindow)
(use Obj)


(local
	local0
)
(procedure (localproc_07c0 param1 param2 param3 &tmp temp0 newEvent temp2 temp3)
	(= temp3
		(+
			(/ (- (param1 nsRight?) (param1 nsLeft?)) 2)
			(param1 nsLeft?)
		)
	)
	(= temp2 param2)
	(return
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							((= newEvent (Event new:)) x: temp3 y: temp2 yourself:)
					)
				)
				(newEvent dispose:)
				(return temp0)
			)
			(newEvent dispose:)
			(if (< param2 param3)
				(= temp2 (+ temp2 4))
			else
				(= temp2 (- temp2 4))
			)
		)
	)
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 4
		modifiers $0000
		signal $0000
		helpStr 0
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		description 0
		owner 0
		script 0
		value 0
	)
	
	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)
	
	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== highlightColor -1) (return))
		(= temp4
			(if (and argc param1) highlightColor else lowlightColor)
		)
		(= temp0 (- nsTop 2))
		(= temp1 (- nsLeft 2))
		(= temp2 (+ nsBottom 1))
		(= temp3 (+ nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph
			grUPDATE_BOX
			(- nsTop 2)
			(- nsLeft 2)
			(+ nsBottom 2)
			(+ nsRight 2)
			1
		)
	)
	
	(method (onMe param1)
		(return (if (super onMe: param1) (not (& signal $0004)) else 0))
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner theOwner)
		(if (and value (= theOwner gLarry))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc255_4 995 0 description)
			)
		)
	)
)

(class Inv of IconBar
	(properties
		elements 0
		size 0
		height 0
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		port 0
		window 0
		state $0400
		activateHeight 0
		y 0
		normalHeading {Roger is carrying:}
		heading 0
		empty {nothing!}
		curScore {Score: %d out of %d}
		showScore 1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)
	
	(procedure (localproc_01aa param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 gInvFirst temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20)
		(= temp0
			(= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))
		)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			((= temp9 (NodeValue gInvFirst)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal?) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal?) $0004))
				)
			else
				(++ temp3)
				(= temp5
					(+
						temp5
						(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
					)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(if (not temp0)
			(proc255_4 995 1 normalHeading empty)
			(return)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3) (= temp16 3))
		(if
		(< (* temp16 (= local0 (/ temp0 temp16))) temp0)
			(++ local0)
		)
		(= temp10
			(proc999_3 (+ 4 temp5) (* local0 (+ 4 temp2)))
		)
		(= temp12
			(/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2)
		)
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (gInv window?)
			((gInv window?)
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open:
			)
		)
		(= temp20 local0)
		(if temp0
			(= temp18
				(+
					2
					(if ((gInv window?) respondsTo: #yOffset)
						((gInv window?) yOffset?)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if ((gInv window?) respondsTo: #xOffset)
							((gInv window?) xOffset?)
						else
							0
						)
					)
				)
			)
			(= gInvFirst (gInv first:))
			(while gInvFirst
				(if
					(and
						(not
							(& ((= temp9 (NodeValue gInvFirst)) signal?) $0004)
						)
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal?) $0080))
						(temp9
							nsLeft:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft?) temp6)
							nsBottom: (+ (temp9 nsTop?) temp7)
						)
						(if (-- temp20)
							(= temp17 (+ temp17 temp2))
						else
							(= temp20 local0)
							(= temp18 (+ temp18 temp1))
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft?))
						(= temp18 (temp9 nsTop?))
					)
					(temp9 show:)
					(if (== temp9 param2) (temp9 highlight:))
				)
				(= gInvFirst (gInv next: gInvFirst))
			)
		)
		(= temp17
			(/
				(-
					(- ((gInv window?) right?) ((gInv window?) left?))
					temp5
				)
				2
			)
		)
		(= temp11
			(- ((gInv window?) bottom?) ((gInv window?) top?))
		)
		(= temp18 32767)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			(not ((= temp9 (NodeValue gInvFirst)) isKindOf: InvI))
				(= temp6
					(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(= temp7
					(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(if (not (& (temp9 signal?) $0080))
					(if (== temp18 32767) (= temp18 (- temp11 temp7)))
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft?) temp6))
				(= temp18 (temp9 nsTop?))
				(temp9 signal: (& (temp9 signal?) $fffb) show:)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
	)
	
	
	(method (init)
		(= gInv self)
		(= heading normalHeading)
	)
	
	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8)
		(asm
code_084c:
			pushi    #type
			pushi    0
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp1
			send     4
			bnt      code_0867
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			jmp      code_084c
code_0867:
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			ldi      0
			sat      temp1
code_0872:
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp1
			bnt      code_0c8b
			pTos     state
			ldi      32
			and     
			bnt      code_0c8b
			ldi      0
			sat      temp8
			pushi    #localize
			pushi    0
			lat      temp1
			send     4
			pToa     curIcon
			bnt      code_091c
			pushi    #modifiers
			pushi    0
			lat      temp1
			send     4
			not     
			bnt      code_091c
			pTos     curIcon
			pToa     selectIcon
			ne?     
			bnt      code_091c
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      1
			eq?     
			bt       code_08f1
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      4
			eq?     
			bnt      code_08db
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      13
			eq?     
			bnt      code_08db
			ldi      1
			sat      temp8
			bt       code_08f1
code_08db:
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      256
			eq?     
			bnt      code_091c
			ldi      1
			sat      temp8
			bnt      code_091c
code_08f1:
			pTos     curIcon
			pToa     helpIconItem
			ne?     
			bt       code_0907
			pushi    #signal
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			ldi      16
			and     
			bnt      code_091c
code_0907:
			pushi    #type
			pushi    1
			pushi    16384
			pushi    40
			pushi    1
			pushi    #message
			pushi    0
			pToa     curIcon
			send     4
			push    
			lat      temp1
			send     12
code_091c:
			pushi    1
			lst      temp1
			callk    MapKeyToDir,  2
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			sat      temp2
			push    
			ldi      1
			eq?     
			bnt      code_094d
			pushi    #modifiers
			pushi    0
			lat      temp1
			send     4
			bnt      code_094d
			pushi    #advanceCurIcon
			pushi    0
			self     4
			pushi    #claimed
			pushi    1
			pushi    1
			lat      temp1
			send     6
			jmp      code_0c81
code_094d:
			lst      temp2
			ldi      0
			eq?     
			bnt      code_0976
			pushi    #firstTrue
			pushi    2
			pushi    196
			lst      temp1
			self     8
			sat      temp0
			bnt      code_0976
			push    
			pToa     highlightedIcon
			ne?     
			bnt      code_0976
			pushi    #highlight
			pushi    1
			lst      temp0
			self     6
			jmp      code_0c81
code_0976:
			lst      temp2
			ldi      1
			eq?     
			bt       code_099d
			lst      temp2
			ldi      4
			eq?     
			bnt      code_0994
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      13
			eq?     
			bt       code_099d
code_0994:
			lst      temp2
			ldi      256
			eq?     
			bnt      code_0a2e
code_099d:
			pushi    1
			pTos     highlightedIcon
			callk    IsObject,  2
			bnt      code_0c81
			pushi    168
			pushi    #-info-
			pTos     highlightedIcon
			lst      temp2
			ldi      1
			eq?     
			push    
			self     8
			bnt      code_0c81
			pTos     highlightedIcon
			pToa     okButton
			eq?     
			bnt      code_09c5
			jmp      code_0c8b
			jmp      code_0c81
code_09c5:
			pTos     highlightedIcon
			pToa     helpIconItem
			eq?     
			bnt      code_0a16
			pushi    #cursor
			pushi    0
			pToa     highlightedIcon
			send     4
			push    
			ldi      65535
			ne?     
			bnt      code_09eb
			pushi    #setCursor
			pushi    1
			pushi    #cursor
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			lag      gGame
			send     6
code_09eb:
			pTos     state
			ldi      2048
			and     
			bnt      code_09fd
			pushi    #noClickHelp
			pushi    0
			self     4
			jmp      code_0c81
code_09fd:
			pToa     helpIconItem
			bnt      code_0c81
			pushi    17
			pushi    #superClass
			pushi    #signal
			pushi    0
			send     4
			push    
			ldi      16
			or      
			push    
			pToa     helpIconItem
			send     6
			jmp      code_0c81
code_0a16:
			pToa     highlightedIcon
			aTop     curIcon
			pushi    #setCursor
			pushi    2
			pushi    #cursor
			pushi    0
			pToa     curIcon
			send     4
			push    
			pushi    1
			lag      gGame
			send     8
			jmp      code_0c81
code_0a2e:
			lst      temp2
			ldi      64
			and     
			bnt      code_0aef
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			dup     
			ldi      3
			eq?     
			bnt      code_0a4e
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0aeb
code_0a4e:
			dup     
			ldi      7
			eq?     
			bnt      code_0a5e
			pushi    #retreat
			pushi    0
			self     4
			jmp      code_0aeb
code_0a5e:
			dup     
			ldi      1
			eq?     
			bnt      code_0a96
			pToa     highlightedIcon
			bnt      code_0a8d
			pushi    3
			push    
			pushi    #nsTop
			pushi    0
			send     4
			push    
			ldi      1
			sub     
			push    
			pushi    0
			call     localproc_07c0,  6
			sat      temp0
			bnt      code_0a8d
			pushi    #highlight
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0aeb
code_0a8d:
			pushi    #retreat
			pushi    0
			self     4
			jmp      code_0aeb
code_0a96:
			dup     
			ldi      5
			eq?     
			bnt      code_0ad6
			pToa     highlightedIcon
			bnt      code_0acd
			pushi    3
			push    
			pushi    #nsBottom
			pushi    0
			send     4
			push    
			ldi      1
			add     
			push    
			pushi    #bottom
			pushi    0
			pToa     window
			send     4
			push    
			call     localproc_07c0,  6
			sat      temp0
			bnt      code_0acd
			pushi    #highlight
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0aeb
code_0acd:
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0aeb
code_0ad6:
			dup     
			ldi      0
			eq?     
			bnt      code_0aeb
			lst      temp2
			ldi      4
			and     
			bnt      code_0aeb
			pushi    #advanceCurIcon
			pushi    0
			self     4
code_0aeb:
			toss    
			jmp      code_0c81
code_0aef:
			lst      temp2
			ldi      4
			eq?     
			bnt      code_0b21
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			dup     
			ldi      9
			eq?     
			bnt      code_0b0f
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0b1d
code_0b0f:
			dup     
			ldi      3840
			eq?     
			bnt      code_0b1d
			pushi    #retreat
			pushi    0
			self     4
code_0b1d:
			toss    
			jmp      code_0c81
code_0b21:
			lst      temp2
			ldi      16384
			eq?     
			bnt      code_0c81
			pushi    #firstTrue
			pushi    2
			pushi    196
			lst      temp1
			self     8
			sat      temp0
			bnt      code_0c81
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      6
			eq?     
			bnt      code_0bc9
			lat      temp0
			bnt      code_0ba8
			pushi    #helpStr
			pushi    0
			send     4
			bnt      code_0ba8
			pushi    #respondsTo
			pushi    1
			pushi    340
			lag      gWindow
			send     6
			bnt      code_0b95
			pushi    #eraseOnly
			pushi    0
			lag      gWindow
			send     4
			sat      temp6
			pushi    #eraseOnly
			pushi    1
			pushi    1
			lag      gWindow
			send     6
			pushi    3
			pushi    995
			pushi    0
			pushi    #helpStr
			pushi    0
			lat      temp0
			send     4
			push    
			calle    proc255_4,  6
			pushi    #eraseOnly
			pushi    1
			lst      temp6
			lag      gWindow
			send     6
			jmp      code_0ba8
code_0b95:
			pushi    3
			pushi    995
			pushi    0
			pushi    #helpStr
			pushi    0
			lat      temp0
			send     4
			push    
			calle    proc255_4,  6
code_0ba8:
			pushi    17
			pushi    #superClass
			pushi    #signal
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			ldi      65519
			and     
			push    
			pToa     helpIconItem
			send     6
			pushi    #setCursor
			pushi    1
			pushi    999
			lag      gGame
			send     6
			jmp      code_0c81
code_0bc9:
			lst      temp0
			pToa     okButton
			eq?     
			bnt      code_0bd7
			jmp      code_0c8b
			jmp      code_0c81
code_0bd7:
			pushi    #isKindOf
			pushi    1
			class    InvI
			push    
			lat      temp0
			send     6
			not     
			bnt      code_0c0c
			pushi    #select
			pushi    2
			lst      temp0
			lat      temp8
			not     
			push    
			self     8
			bnt      code_0c81
			lat      temp0
			aTop     curIcon
			pushi    #setCursor
			pushi    2
			pushi    #cursor
			pushi    0
			pToa     curIcon
			send     4
			push    
			pushi    1
			lag      gGame
			send     8
			jmp      code_0c81
code_0c0c:
			pToa     curIcon
			bnt      code_0c81
			pushi    #respondsTo
			pushi    1
			pushi    340
			lag      gWindow
			send     6
			bnt      code_0c31
			pushi    #eraseOnly
			pushi    0
			lag      gWindow
			send     4
			sat      temp6
			pushi    #eraseOnly
			pushi    1
			pushi    1
			lag      gWindow
			send     6
code_0c31:
			pushi    #isKindOf
			pushi    1
			class    InvI
			push    
			pToa     curIcon
			send     6
			bnt      code_0c5a
			pushi    #doVerb
			pushi    2
			pushi    #message
			pushi    0
			pToa     curIcon
			send     4
			push    
			pushi    #indexOf
			pushi    1
			pTos     curIcon
			self     6
			push    
			lat      temp0
			send     8
			jmp      code_0c6a
code_0c5a:
			pushi    #doVerb
			pushi    1
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			lat      temp0
			send     6
code_0c6a:
			pushi    #respondsTo
			pushi    1
			pushi    340
			lag      gWindow
			send     6
			bnt      code_0c81
			pushi    #eraseOnly
			pushi    1
			lst      temp6
			lag      gWindow
			send     6
code_0c81:
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			jmp      code_0872
code_0c8b:
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			pushi    #hide
			pushi    0
			self     4
			ret     
		)
	)
	
	(method (showSelf param1)
		(gSounds pause:)
		(if
		(and gPseudoMouse (gPseudoMouse respondsTo: #stop))
			(gPseudoMouse stop:)
		)
		(if (gIconBar height?) (gIconBar hide:))
		(if (not window) (= window (SysWindow new:)))
		(if (window window?) (window dispose:) (= window 0))
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(gGame setCursor: (selectIcon cursor?))
		(self show: (if argc param1 else gLarry) doit:)
	)
	
	(method (show param1 &tmp temp0)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(= state (| state $0020))
		(localproc_01aa
			(if argc param1 else gLarry)
			(gIconBar curIcon?)
		)
		(PicNotValid temp0)
	)
	
	(method (hide)
		(if (& state $0020)
			(gSounds pause: 0)
			(= state (& state $ffdf))
		)
		(if window (window dispose:))
		(if
		(and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gIconBar curInvIcon?))
				(gIconBar enable: (gIconBar useIconItem?))
			)
			(gIconBar
				curIcon: ((gIconBar useIconItem?)
					cursor: (curIcon cursor?)
					yourself:
				)
				curInvIcon: curIcon
			)
		)
		(if ((gIconBar curIcon?) cursor?)
			(gGame setCursor: ((gIconBar curIcon?) cursor?) 1)
		)
	)
	
	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(+ temp1 (= temp2 (self indexOf: highlightedIcon)))
		)
		(repeat
			(= temp0
				(self
					at: (if (<= temp3 size) temp3 else (mod temp3 (- size 1)))
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(++ temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(- (= temp2 (self indexOf: highlightedIcon)) temp1)
		)
		(repeat
			(= temp0 (self at: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(-- temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (advanceCurIcon &tmp theCurIcon)
		(= theCurIcon curIcon)
		(while
			((= theCurIcon
				(self at: (mod (+ (self indexOf: theCurIcon) 1) size))
			)
				isKindOf: InvI
			)
		)
		(= curIcon theCurIcon)
		(gGame setCursor: (curIcon cursor?) 1)
	)
	
	(method (ownedBy param1)
		(self firstTrue: #ownedBy param1)
	)
)
