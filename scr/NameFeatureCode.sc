;;; Sierra Script 1.0 - (do not remove this comment)
(script# 10)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n940)
(use CueObj)
(use SysWindow)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	debugHandler 0
)

(local
	newDButton
	[local1 26]
)
(procedure (localproc_0049)
	(if (proc999_5 (global2 style?) 11 12 13 14)
		(global2 drawPic: (global2 picture?) 100 style: 100)
	)
)

(instance debugHandler of Feature
	(properties)
	
	(method (init)
		(super init:)
		(gLl5MDHandler addToFront: self)
		(gLl5KDHandler addToFront: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(super dispose:)
		(DisposeScript 974)
		(DisposeScript 10)
	)
	
	(method (handleEvent pEvent &tmp [temp0 150] [temp150 10] temp160 newEvent gCastFirst temp163 [temp164 8])
		(switch (pEvent type?)
			(evKEYBOARD
				(pEvent claimed: 1)
				(switch (pEvent message?)
					(KEY_ALT_a
						(= gCastFirst (gCast first:))
						(while gCastFirst
							(= temp163 (NodeValue gCastFirst))
							(Format
								@temp0
								10
								1
								((temp163 superClass?) name?)
								(temp163 view?)
								(temp163 loop?)
								(temp163 cel?)
								(temp163 x?)
								(temp163 y?)
								(temp163 z?)
								(temp163 heading?)
								(temp163 priority?)
								(temp163 signal?)
								(if
									(or
										(== (temp163 superClass?) Actor)
										(== (temp163 superClass?) Ego)
									)
									(temp163 illegalBits?)
								else
									-1
								)
							)
							(proc255_0
								@temp0
								35
								SysWindow
								80
								(temp163 name?)
								82
								(temp163 view?)
								(temp163 loop?)
								(temp163 cel?)
							)
							(= gCastFirst (gCast next: gCastFirst))
						)
					)
					(KEY_ALT_c
						(localproc_0049)
						(Show 4)
						(Animate (gCast elements?))
						(while (== 0 ((= pEvent (Event new: 32765)) type?))
							(pEvent dispose:)
						)
						(pEvent dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(Format
							@temp0
							10
							2
							(gLarry name?)
							(gLarry view?)
							(gLarry loop?)
							(gLarry cel?)
							(gLarry x?)
							(gLarry y?)
							(gLarry z?)
							(gLarry heading?)
							(gLarry priority?)
							(gLarry signal?)
							(gLarry illegalBits?)
							(gLarry onControl:)
							(gLarry onControl: 1)
						)
						(proc255_0
							@temp0
							82
							(gLarry view?)
							(gLarry loop?)
							(gLarry cel?)
						)
					)
					(KEY_ALT_f
						(gFeatures eachElementDo: #perform showFeatureCode)
						(NameFeatureCode init:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(proc255_2 @temp0 4 {Variable No.})
						(= gCastFirst (ReadNumber @temp0))
						(= temp0 0)
						(proc255_2 @temp0 4 {Value})
						(= [gLarry gCastFirst] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(proc255_2 @temp0 4 {Variable No.})
						(= gCastFirst (ReadNumber @temp0))
						(if (IsObject [gLarry gCastFirst])
							(Format
								@temp0
								10
								3
								gCastFirst
								([gLarry gCastFirst] name?)
							)
							(proc255_0 @temp0)
						else
							(Format @temp0 10 4 gCastFirst [gLarry gCastFirst])
							(proc255_0 @temp0)
						)
						(= temp0 0)
					)
					(KEY_ALT_i (dInvD doit:))
					(KEY_ALT_m
						(Format @temp0 10 0 global152)
						(Format @temp150 10 0 global153)
						(proc940_0
							{Dolary:_}
							41
							@temp0
							6
							106
							{Støíbro:__}
							41
							@temp150
							6
						)
						(gLarry put: 12 0)
						(gLarry put: 17 0)
						(if (= global152 (ReadNumber @temp0)) (gLarry get: 12))
						(if (= global153 (ReadNumber @temp150))
							(gLarry get: 17)
						)
					)
					(KEY_ALT_p
						(localproc_0049)
						(Show 2)
					)
					(KEY_ALT_q
						(gGame detailLevel: 1)
					)
					(KEY_ALT_r
						(Format
							@temp0
							10
							5
							(global2 name?)
							gNumber
							(global2 curPic?)
							(global2 style?)
							(global2 horizon?)
							(global2 north?)
							(global2 south?)
							(global2 east?)
							(global2 west?)
							(if (IsObject (global2 script?))
								((global2 script?) name?)
							else
								{..nic..}
							)
						)
						(proc255_0 @temp0 70 120)
						(gGame showMem:)
					)
					(KEY_ALT_t
						(if gTheNewDialog (gTheNewDialog dispose:))
						(if (> (= gCastFirst (proc255_3 {Teleportuj})) 0)
							(global2 newRoom: gCastFirst)
							(= gGCastFirst gCastFirst)
						)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gIconBar enable: 0 1 2 3 4 5 6 7)
					)
					(KEY_ALT_v (Show 1))
					(KEY_ALT_x (= global4 1))
					(KEY_ALT_z (= global4 1))
					(else  (pEvent claimed: 0))
				)
			)
			(evMOUSEBUTTON
				(switch (pEvent modifiers?)
					(13 0)
					(14 0)
					(12
						(pEvent claimed: 1)
						(Format @temp0 10 6 (pEvent x?) (pEvent y?))
						(= temp160 (proc255_0 @temp0 67 160 10 33 999 108))
						(while (!= 2 ((= newEvent (Event new:)) type?))
							(newEvent dispose:)
						)
						(newEvent dispose:)
						(temp160 dispose:)
					)
					(5
						(pEvent type: 4 message: 4864)
						(self handleEvent: pEvent)
					)
					(6
						(pEvent type: 4 message: 4608)
						(self handleEvent: pEvent)
					)
					(9 0)
					(10 0)
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(pEvent claimed: 1)
						(while (!= 2 ((= newEvent (Event new:)) type?))
							((User alterEgo?)
								posn: (newEvent x?) (- (newEvent y?) 10)
								setMotion: 0
							)
							(Animate (gCast elements?) 0)
							(newEvent dispose:)
						)
						(newEvent dispose:)
					)
				)
			)
		)
	)
)

(instance dInvD of Dialog
	(properties)
	
	(method (init &tmp temp0 temp1 temp2 temp3 newDText gInvFirst temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(= temp6 (NodeValue gInvFirst))
			(++ temp3)
			(if (temp6 isKindOf: InvI)
				(self
					add:
						((= newDText (DText new:))
							value: temp6
							text: (temp6 name?)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: global23
							setSize:
							yourself:
						)
				)
			)
			(if
			(< temp2 (- (newDText nsRight?) (newDText nsLeft?)))
				(= temp2 (- (newDText nsRight?) (newDText nsLeft?)))
			)
			(if
				(>
					(= temp1
						(+ temp1 (- (newDText nsBottom?) (newDText nsTop?)) 1)
					)
					140
				)
				(= temp1 4)
				(= temp0 (+ temp0 temp2 10))
				(= temp2 0)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(= window gWindow)
		(self setSize:)
		(= newDButton (DButton new:))
		(newDButton
			text: {Pryè!}
			setSize:
			moveTo: (- nsRight (+ 4 (newDButton nsRight?))) nsBottom
		)
		(newDButton
			move: (- (newDButton nsLeft?) (newDButton nsRight?)) 0
		)
		(self add: newDButton setSize: center:)
		(return temp3)
	)
	
	(method (doit &tmp theNewDButton)
		(self init:)
		(self open: 4 15)
		(= theNewDButton newDButton)
		(repeat
			(if
				(or
					(not (= theNewDButton (super doit: theNewDButton)))
					(== theNewDButton -1)
					(== theNewDButton newDButton)
				)
				(break)
			)
			(gLarry get: (Inv indexOf: (theNewDButton value?)))
		)
		(self dispose:)
	)
	
	(method (handleEvent pEvent &tmp pEventMessage pEventType)
		(= pEventMessage (pEvent message?))
		(switch (= pEventType (pEvent type?))
			(4
				(switch pEventMessage
					(KEY_UP (= pEventMessage 3840))
					(KEY_NUMPAD2
						(= pEventMessage 9)
					)
				)
			)
			(64
				(switch pEventMessage
					(JOY_UP
						(= pEventMessage 3840)
						(= pEventType 4)
					)
					(JOY_DOWN
						(= pEventMessage 9)
						(= pEventType 4)
					)
				)
			)
		)
		(pEvent type: pEventType message: pEventMessage)
		(super handleEvent: pEvent)
	)
)

(instance showFeatureCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (param1 nsTop?))
		(= temp1 (param1 nsLeft?))
		(= temp3 (param1 nsBottom?))
		(= temp2 (param1 nsRight?))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp2 1 15)
		(Graph grDRAW_LINE temp3 temp1 temp3 temp2 1 15)
		(Graph grDRAW_LINE temp0 temp1 temp3 temp1 1 15)
		(Graph grDRAW_LINE temp0 temp2 temp3 temp2 1 15)
		(Graph
			grUPDATE_BOX
			temp0
			temp1
			(+ temp3 1)
			(+ temp2 1)
			1
		)
	)
)

(class NameFeatureCode of Code
	(properties)
	
	(method (init)
		(gLl5KDHandler addToFront: self)
		(gTheDoits add: self)
	)
	
	(method (doit &tmp onMeAndLowYTheObj [temp1 40])
		(OnMeAndLowY init:)
		(gFeatures
			eachElementDo: #perform OnMeAndLowY (User curEvent?)
		)
		(if (= onMeAndLowYTheObj (OnMeAndLowY theObj?))
			(DrawStatus
				(Format
					@temp1
					10
					7
					((User curEvent?) x?)
					((User curEvent?) y?)
					(onMeAndLowYTheObj name?)
				)
			)
		)
	)
	
	(method (dispose)
		(DrawStatus 0)
		(DrawStatus {_} global122 0)
		(gLl5KDHandler delete: self)
		(gTheDoits delete: self)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent message?) KEY_ESCAPE)
			)
			(pEvent claimed: 1)
			(self dispose:)
		)
	)
)
